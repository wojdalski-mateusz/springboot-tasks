package pl.wojdalski.homework2.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@Profile("PRO")
public class ShopPro extends ShopPlus {

    private BigDecimal calculateSumPro;

    @Value("${disc}")
    double disc;

    @Override
    public void showProducts() {
        super.showProducts();
    }

    @Override
    public void calculateSum() {
        super.calculateSum();
        calculateSumPro = BigDecimal.valueOf(calculateSumPlus - (calculateSumPlus * disc)).setScale(2, RoundingMode.HALF_UP);
        System.out.println("Total price with vat and discount: " + calculateSumPro);
    }
}
