package pl.wojdalski.homework2.model;

import java.math.BigDecimal;

public class Product {

    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return BigDecimal.valueOf(price).setScale(2).doubleValue();
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product name - " + name +
                ", price - " + price;
    }
}
