package com.contract.example.producer.core;

public class NegativeQuantityException extends IllegalArgumentException {

    public NegativeQuantityException(String message) {
        super(message);
    }
}
