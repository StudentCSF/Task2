package course2.oop.task1.data.supermarket.premise;

import course2.oop.task1.data.products.BaseProduct;

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
