package com.contract.example.producer.core;

import lombok.Data;

import java.util.List;

@Data
public class Order {
    private List<OrderItem> orderItems;
}
