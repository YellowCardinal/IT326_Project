package com.egg.model;

import org.springframework.data.annotation.Id;

public class Item {

    @Id
    private String itemId;

    private Double price;
    private String condition;
    private User seller;
    private Boolean isAvailable;

    public void updatePrice(Double newPrice) {
        this.price = newPrice;
    }

    public void markAsSold() {
        this.isAvailable = false;
    }
}
