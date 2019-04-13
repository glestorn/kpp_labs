package com.services.counter_service;

import org.springframework.stereotype.Service;

@Service
public class Counter {

    private long counter;

    public void increment() { counter++; }

    public long getCounter() { return counter; }
}
