package pl.wojdalski.homework2.service;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.wojdalski.homework2.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Service
@Profile("START")
public class ShopStart {

    double sum = 0;
    private List<Product> products;

    public ShopStart(){
        Product product1 = new Product("Jacket", randomPrice());
        Product product2 = new Product("TV", randomPrice());
        Product product3 = new Product("Shoes", randomPrice());
        Product product4 = new Product("Phone", randomPrice());
        Product product5 = new Product("Bike", randomPrice());

        products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
    }

    private double randomPrice(){
        double minPrice = 50;
        double maxPrice = 300;
        double price = BigDecimal.valueOf(Math.random() * (maxPrice - minPrice + 1)
                + minPrice).setScale(2, RoundingMode.HALF_UP).doubleValue();
        return price;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showProducts(){
        products.forEach(System.out::println);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void calculateSum(){
        sum = BigDecimal.valueOf(products.stream().mapToDouble(Product::getPrice).sum()).doubleValue();
        System.out.println("Total price: " + sum);
    }
}
