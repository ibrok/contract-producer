package com.contract.example.producer.core;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

@Component
public class BeerService {

    private final BeerMenu beerMenu;

    private final List<Order> orders = new ArrayList<>();

    public BeerMenu getBeerMenu() {
        return beerMenu;
    }

    public BeerMenu getBeerMenu(BeerType type) {
        return new BeerMenu(beerMenu.getBeerList().stream().filter(beer -> type == beer.getType()).collect(toList()));
    }

    public String order(final Order order) {
        orders.add(order);
        return "Here you go!";
    }

    {
        List<Beer> beerList = asList(
                new Beer("Brand", BeerType.PILS, BigDecimal.valueOf(5)),
                new Beer("Brand", BeerType.ALC_VRIJ, BigDecimal.valueOf(0)),
                new Beer("Jupiler", BeerType.PILS, BigDecimal.valueOf(5.2)),
                new Beer("Dommelsch", BeerType.PILS, BigDecimal.valueOf(5)),
                new Beer("Grolsch", BeerType.PILS, BigDecimal.valueOf(5)),
                new Beer("Bavaria", BeerType.PILS, BigDecimal.valueOf(5)),
                new Beer("Bavaria", BeerType.ALC_VRIJ, BigDecimal.valueOf(0)),
                new Beer("Leffe", BeerType.BLOND, BigDecimal.valueOf(6.6)),
                new Beer("Leffe", BeerType.TRIPLE, BigDecimal.valueOf(8.5)),
                new Beer("Karmeliet", BeerType.TRIPLE, BigDecimal.valueOf(8.4)),
                new Beer("Brugse Zot", BeerType.BLOND, BigDecimal.valueOf(6)),
                new Beer("Brugse Zot", BeerType.DUBBEL, BigDecimal.valueOf(7.5)),
                new Beer("Wieckse witte", BeerType.BLOND, BigDecimal.valueOf(5)));
        beerMenu = new BeerMenu(beerList);
    }

}
