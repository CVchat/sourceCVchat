package telran.m2m.service;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import telran.m2m.dto.Room;
import telran.m2m.dto.RoomData;
import telran.m2m.model.RoomSimulation;

/**
 * Room Data Generator Class for the Room Data generation in the monitoring and control system for buildings
 * made for generation of imitation model to test the functionality of microservices project
 * @author Andrey Lavrinenko
 */
@EnableBinding(Source.class)
public class RoomDataGenerator {

	/**
	 * Object mapper to map the objects
	 */
	ObjectMapper mapper=new ObjectMapper();

	/**
	 * Randomization object
	 */
	Random random = new Random();

	/**
	 * Amount of rooms in simulation, must be not zero
	 */
	@Value("${n_rooms:10}")
	int nRooms;

	/**
	 * Current chosen number of room for data transfer
	 */
	int currentRoomIndex = 0;

	/**
	 * List of rooms for simulation
	 */
	ArrayList<Room> rooms = new ArrayList<>();

	/**
	 * Gets room data to send it through the kafka
	 * @return mapped string
	 * @throws JsonProcessingException
	 */
	@InboundChannelAdapter(value=Source.OUTPUT,poller=@Poller
							(fixedDelay="${fixedDelay:1000}"
							, maxMessagesPerPoll="${nMessages:1}"))
	String getRoomData() throws JsonProcessingException {
		RoomData roomData = getUpdatedRoomData();
		return mapper.writeValueAsString(roomData);
	}

	/**
	 * Updated room data after certain amount of time
	 * @return updated room data
	 */
	private RoomData getUpdatedRoomData() {
		long timestamp=System.currentTimeMillis();
		if (rooms.size() == 0) {
			createRooms();
		}
		RoomData roomData = new RoomData(currentRoomIndex, timestamp, rooms.get(currentRoomIndex));
		if (currentRoomIndex < nRooms - 1) {
			currentRoomIndex++;
		} else {
			currentRoomIndex = 0;
		}
		return roomData;
		//TODO check functionality with kafka and integration tests
		
	}

	/**
	 * Creates requested amount of rooms
	 */
	private void createRooms() {
		RoomSimulation roomSimulation = new RoomSimulation();
		for (int i = 0; i < nRooms; i++) {
			Room room = roomSimulation.startRoomSimulation();
			rooms.add(room);
		}
	}

//	/**
//	 * Update rooms simulation
//	 */
//	private void updateRooms() {
//		RoomSimulation roomSimulation = new RoomSimulation();
//		for (int i = 0; i < nRooms; i++) {
//			Room room = roomSimulation.startRoomSimulation();
//			rooms.add(room);
//		}
//	}  //TODO update room simulation

	/**
	 * Generates random integer number
	 * @param min minimum value
	 * @param max maximum value
	 * @return random value
	 */
	private int getRandomNumber(int min,int max) {
		return random.ints(1, min,max+1).findFirst().getAsInt();
	}

	public int getnRooms() {
		return nRooms;
	}

	public void setnRooms(int nRooms) {
		this.nRooms = nRooms;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
}
