package com.contract.example.producer.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class BeerMenu {

    private List<Beer> beerList;
}
