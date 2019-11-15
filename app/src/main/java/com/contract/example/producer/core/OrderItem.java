package com.contract.example.producer.core;

import lombok.Data;

@Data
public class OrderItem {
    private Beer beer;
    private int quantity;
}
