package com.starter.plate.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ThreadService implements ThreadInterface {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadService.class);

    public ThreadService() {
    }

    @Async
    @Override
    public CompletableFuture<Double> addDigits(double one, double two) {
        try {
            Thread.sleep(1000);
            LOGGER.info("Here thread one");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(one + two);
    }


    @Async
    @Override
    public CompletableFuture<Double> divided(double divide) {
        try {
            Thread.sleep(500);
            LOGGER.info("Here thread two");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(1 / divide);
    }
}
