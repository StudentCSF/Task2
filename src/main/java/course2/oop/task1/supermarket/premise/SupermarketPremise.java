package course2.oop.task1.supermarket.premise;

import course2.oop.task1.products.*;

import java.util.HashMap;
import java.util.Map;

public abstract class SupermarketPremise {
    protected Map<BaseProduct, Double> products;

    public SupermarketPremise() {
        products = new HashMap<BaseProduct, Double>();
    }

    public Map<BaseProduct, Double> getProducts() {
        return products;
    }

    public void setProducts(Map<BaseProduct, Double> products) {
        this.products = products;
    }
}
