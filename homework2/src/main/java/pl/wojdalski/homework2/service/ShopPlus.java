package pl.wojdalski.homework2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Profile("PLUS")
public class ShopPlus extends ShopStart {

    double calculateSumPlus;

    @Value("${vat}")
    double vat;

    @Override
    public void showProducts() {
        super.showProducts();
    }

    @Override
    public void calculateSum() {
        super.calculateSum();
        calculateSumPlus = BigDecimal.valueOf(sum + (sum * vat)).setScale(2, RoundingMode.HALF_UP).doubleValue();
        System.out.println("Total price with vat: " + calculateSumPlus);
    }
}
