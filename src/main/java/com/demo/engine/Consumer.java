package com.demo.engine;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.annotation.PartitionOffset;

@Service
public class Consumer {

    private final Logger logger = LoggerFactory.getLogger(Producer.class);

    //@KafkaListener(topicPartitions 
    //       		= @TopicPartition(topic = "users1", partitionOffsets = {
    //            @PartitionOffset(partition = "0", initialOffset = "0")}), groupId = "quarkus-kafka-quickstart",
    //           containerFactory = "kafkaListenerContainerFactory")
    @KafkaListener(topics = "users1", groupId = "quarkus-kafka-quickstart")
    public void consume(String message) throws IOException {
        try {
            logger.info(String.format("#### -> Consumed message -> %s", message));
        }
       	catch (Exception e) {
    		logger.info("Error: " + e.getMessage());
    	}
    }
}
