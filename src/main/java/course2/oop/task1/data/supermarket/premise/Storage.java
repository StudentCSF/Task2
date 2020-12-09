package course2.oop.task1.data.supermarket.premise;


import course2.oop.task1.data.products.BaseProduct;

import java.util.Map;

public class Storage extends SupermarketPremise {
    public Storage(Map<BaseProduct, Double> products) {
        super(products);
    }

    public Storage() {
    }
}
