package com.starter.plate.service;

import java.util.concurrent.CompletableFuture;

public interface ThreadInterface {


    public CompletableFuture<Double> addDigits(double one, double two);

    public CompletableFuture<Double> divided(double divide);
}
