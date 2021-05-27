package com.starter.plate.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;

public class Topics {

    @Bean
    public NewTopic searchTopic() {
        return new NewTopic("search", 1, (short) 1);
    }
}
