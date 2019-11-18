package com.contract.example.producer.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.contract.example.producer.core.NegativeQuantityException;

@ControllerAdvice
public class BeerExceptionHandler {

    @ExceptionHandler(NegativeQuantityException.class)
    public ResponseEntity<String> handleNegativeQuantityException(NegativeQuantityException negativeQuantityException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(negativeQuantityException.getMessage());
    }
}
