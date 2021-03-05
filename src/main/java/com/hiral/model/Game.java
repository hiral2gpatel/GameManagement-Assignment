package com.hiral.model;

public abstract class Game {

    private String name;
    private double price;
    private int numberOfQuantity;
    private String producercompany;



    public Game(String name, double price, int numberOfQuantity, String producercompany) {
        this.name = name;
        this.price = price;
        this.numberOfQuantity = numberOfQuantity;
        this.producercompany = producercompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumberOfQuantity() {
        return numberOfQuantity;
    }

    public void setNumberOfQuantity(int numberOfQuantity) {
        this.numberOfQuantity = numberOfQuantity;
    }

    public String getProducercompany() {
        return producercompany;
    }

    public void setProducercompany(String producercompany) {
        this.producercompany = producercompany;
    }
}
