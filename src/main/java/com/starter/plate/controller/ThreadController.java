package com.starter.plate.controller;

import com.starter.plate.service.ThreadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

@RestController
@RequestMapping("/api/thread")
public class ThreadController {

    @Autowired
    ThreadService threadService;


    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadController.class);

    @PostMapping
    public ResponseEntity<Double> testTwoThreads(@RequestParam(value = "digit_one") double digitOne,
                                                 @RequestParam(value = "digit_two") double digitTwo,
                                                 @RequestParam(value = "divide") double divide
    ) {
        try {

            CompletableFuture<Double> dataone = threadService.addDigits(digitOne, digitTwo);
            CompletableFuture<Double> dataTwo = threadService.divided(divide);
            LOGGER.info("Waiting");
            CompletableFuture.allOf(dataone, dataTwo).join();
            Double joindata = dataone.get();
            Double divisor = dataTwo.get();
            LOGGER.info("Completed");
            return ResponseEntity.ok(joindata * divisor);
        } catch (final Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping
    public CompletableFuture<ResponseEntity<Double>> runThreadOne() {
        return threadService.addDigits(1, 2).thenApply(ResponseEntity::ok)
                .exceptionally(handleGetCarFailure);
    }

    private static Function<Throwable, ResponseEntity<Double>> handleGetCarFailure = throwable -> {
        LOGGER.error("Failed to test", throwable);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    };
}
