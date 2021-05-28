package com.starter.plate.controller;

import com.starter.plate.kafka.Producer;
import com.starter.plate.model.SearchRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/search")
public class WordSearchController {

    @Autowired
    private Producer producer;


    @PostMapping
    public ResponseEntity<String> addSearchKeyWork(@RequestBody SearchRequest searchRequest) {
        for (String keyword : searchRequest.getSearchWords()) {
            producer.sendSearchTopic(keyword);
        }
        return ResponseEntity.ok("There there");
    }
}
