package com.demo.engine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "users1";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        try {
            logger.info(String.format("#### -> Producing message -> %s", message));
            this.kafkaTemplate.send(TOPIC, "0", message);
        }
        catch (Exception e) {
    		logger.info("Error: " + e.getMessage());
    	}
    }
}
