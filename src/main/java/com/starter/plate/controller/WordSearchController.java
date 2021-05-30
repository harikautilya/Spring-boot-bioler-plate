package com.starter.plate.controller;

import com.starter.plate.kafka.Producer;
import com.starter.plate.model.SearchRequest;
import com.starter.plate.sqs.SQSConfig;
import com.starter.plate.sqs.SQSProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")
public class WordSearchController {

    @Autowired
    private Producer producer;

    @Autowired
    private SQSProducer sqlProducer;


    @PostMapping
    public ResponseEntity<String> addSearchKeyWordKafka(@RequestBody SearchRequest searchRequest) {
        for (String keyword : searchRequest.getSearchWords()) {
            producer.sendSearchTopic(keyword);

        }
        return ResponseEntity.ok("There there");
    }

    @PutMapping
    public ResponseEntity<String> addSearchKeySQS(@RequestBody SearchRequest searchRequest) {
        for (String keyword : searchRequest.getSearchWords()) {
            sqlProducer.sendSearchMessage(keyword);
        }
        return ResponseEntity.ok("There there");
    }
}
