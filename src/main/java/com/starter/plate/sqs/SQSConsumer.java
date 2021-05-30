package com.starter.plate.sqs;

import com.starter.plate.kafka.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SQSConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SQSConsumer.class);

    @SqsListener("search.fifo")
    public void searchListener(String search) {
        LOGGER.info("Add search " + search);
    }
}
