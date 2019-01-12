package telran.m2m.model;

import org.junit.jupiter.api.Test;
import telran.m2m.dto.Room;

import static org.junit.jupiter.api.Assertions.*;

class RoomSimulationTest {

    @Test
    void startRoomSimulation() {
        RoomSimulation roomSimulation = new RoomSimulation();
        Room room = roomSimulation.startRoomSimulation();
        System.out.println(room);
        System.out.println("Int temp = " + room.getInternalTemperatureC());
        System.out.println("Out temp = " + room.getOutsideTemperatureC());
        for (int i = 0; i < 100; i++) {
            room = roomSimulation.updateRoomSimulation();
            System.out.println(room);
            System.out.println("Int temp = " + room.getInternalTemperatureC());
            System.out.println("Out temp = " + room.getOutsideTemperatureC());
        }
    }
}