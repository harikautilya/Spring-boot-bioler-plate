package com.starter.plate.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Producer {


    @Autowired
    private KafkaTemplate<Object, Object> template;

    public Producer() {
    }

    public void sendSearchTopic(String keyWork) {
        this.template.send("search", keyWork);
    }
}
