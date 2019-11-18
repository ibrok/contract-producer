package com.contract.example.producer.api;

import com.contract.example.producer.core.BeerMenu;
import com.contract.example.producer.core.BeerService;
import com.contract.example.producer.core.BeerType;
import com.contract.example.producer.core.NegativeQuantityException;
import com.contract.example.producer.core.Order;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("beer")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BeerMenu getBeers() {
        return beerService.getBeerMenu();
    }

    @GetMapping(value = "/{type}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public BeerMenu getBeersOfType(@PathVariable BeerType type) {
        return beerService.getBeerMenu(type);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String orderBeers(@RequestBody Order order) {
        if (isValid(order)) {
            return beerService.order(order);
        } else {
            throw new NegativeQuantityException("quantity should not be negative");
        }
    }

    private boolean isValid(Order order) {
        return order.getOrderItems().stream().allMatch(orderItem -> orderItem.getQuantity() >= 0);
    }

}
