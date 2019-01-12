package telran.m2m.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import telran.m2m.model.SourceSentences;


/**
 * Chat Data Generator Class for the Chat Data generation in chat system for CVbank project
 * @author Andrey Lavrinenko
 */
@EnableBinding(Source.class)
public class ChatDataGenerator {

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
		SourceSentences sourceSentences = new SourceSentences();
		return mapper.writeValueAsString(sourceSentences.sentence());
	}


}
