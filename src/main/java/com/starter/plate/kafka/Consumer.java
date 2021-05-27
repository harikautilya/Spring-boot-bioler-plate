package com.starter.plate.kafka;

import org.springframework.kafka.annotation.KafkaListener;

public class Consumer {

    @KafkaListener(id = "", topics = "search")
    public void searchData(String keyword) {
        System.out.println("Add search " + keyword);
    }
}
