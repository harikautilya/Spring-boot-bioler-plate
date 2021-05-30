package com.starter.plate;

import com.starter.plate.kafka.Producer;
import com.starter.plate.sqs.SQSProducer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync(proxyTargetClass = true)
public class PlateApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlateApplication.class, args);
    }


    @Bean
    public Producer getProducer() {
        return new Producer();
    }

    @Bean
    public SQSProducer sqlProducer() {
        return new SQSProducer();
    }




}
