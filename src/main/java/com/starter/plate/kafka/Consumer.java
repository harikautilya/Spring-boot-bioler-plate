package com.starter.plate.kafka;

import com.starter.plate.config.AsyncConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


public class Consumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);


    @KafkaListener(groupId = "search", topics = "search_word")
    public void searchData(String keyword) {
        LOGGER.info("Add search " + keyword);
    }
}
