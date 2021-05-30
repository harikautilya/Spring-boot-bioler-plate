package com.starter.plate.sqs;

import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.amazonaws.services.sqs.model.SendMessageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;
import java.util.Map;

public class SQSProducer {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String seachQueue;

    private static final Logger LOGGER = LoggerFactory.getLogger(SQSProducer.class);


    public void sendSearchMessage(String message) {

        Map<String, Object> headers = new HashMap<>();
        headers.put("message-group-id", "search");
        headers.put("message-deduplication-id", System.currentTimeMillis() + "");
        MessageHeaders messageHeaders = new MessageHeaders(headers);
        queueMessagingTemplate.send(seachQueue, MessageBuilder.createMessage(message, messageHeaders));
        LOGGER.info(message + " SENT ");
    }
}
