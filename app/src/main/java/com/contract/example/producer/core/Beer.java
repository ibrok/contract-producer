package com.contract.example.producer.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Beer {
    private String brand;
    private BeerType type;
    private BigDecimal percentage;
}
