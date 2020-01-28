package com.javadevjournal.feignclientexample;

public class Product {

    private Integer id;

    private String name;

    private double price;

    public Product() {
    }
    
    public Product(Integer id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
