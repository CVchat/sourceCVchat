package telran.m2m.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import telran.m2m.dto.MessageData;
import telran.m2m.model.SourceSentences;


/**
 * Chat Data Generator Class for the Chat Data generation in chat system for CVbank project
 * @author Andrey Lavrinenko
 */
@EnableBinding(Source.class)
public class ChatDataGenerator {

	/**
	 * Probability of critical message
	 */
	private static final double CRITICAL_PROBABILITY = 10;

	/**
	 * Critical message text
	 */
	private static final String CRITICAL_TEXT = "HELP!!! THAT IS CRITICAL ISSUE!!!";

	/**
	 * Object mapper to map the objects
	 */
	ObjectMapper mapper=new ObjectMapper();


	/**
	 * Amount of chats in simulation, must be not zero
	 */
	@Value("${n_chats:10}")
	int nChats;


	/**
	 * Gets room data to send it through the kafka
	 * @return mapped string
	 * @throws JsonProcessingException
	 */
	@InboundChannelAdapter(value=Source.OUTPUT,poller=@Poller
							(fixedDelay="${fixedDelay:1000}"
							, maxMessagesPerPoll="${nMessages:1}"))
	String getChatData() throws JsonProcessingException {
		return mapper.writeValueAsString(getNewMessage());
	}

	/**
	 * Generates new message
	 * @return random message
	 */
	private MessageData getNewMessage() {
		boolean critical = getRandomBooleanWithProbability(CRITICAL_PROBABILITY);
		long timestamp=System.currentTimeMillis();
		String text;
		if (critical) {
			text = CRITICAL_TEXT;
		} else {
			SourceSentences sourceSentences = new SourceSentences();
			text = sourceSentences.sentence();
		}
		MessageData messageData = new MessageData(timestamp, text, critical);
		System.out.println(messageData);
		return  messageData;
	}

	/**
	 * Creates random boolean with probability
	 * @param probability of occurrence
	 * @return if an event occurs
	 */
	private boolean getRandomBooleanWithProbability(double probability) {
		Random random = new Random();
		return random.nextFloat() < (probability / 100.0);
	}
}
