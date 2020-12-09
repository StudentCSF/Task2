package course2.oop.task1.data.supermarket.premise;


import course2.oop.task1.data.products.BaseProduct;

import java.util.Map;

public class TradeHall extends SupermarketPremise {
    public TradeHall(Map<BaseProduct, Double> products) {
        super(products);
    }

    public TradeHall() {
    }
}
