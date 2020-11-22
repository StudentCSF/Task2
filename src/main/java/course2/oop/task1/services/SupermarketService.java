package course2.oop.task1.services;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.supermarket.Supermarket;
import course2.oop.task1.data.supermarket.premise.SupermarketPremise;

import java.util.HashMap;
import java.util.Map;

public class SupermarketService {

    public void addStorage(Supermarket market, Map<BaseProduct, Double> prods) {
        market.getStorage().getProducts().putAll(prods);
    }

    private Map<BaseProduct, Double> removeFromSupermarketPremise(Supermarket market, boolean fromHall,  Map<BaseProduct, Double> prods) {
        Map<BaseProduct, Double> removedProducts = new HashMap<>();

        SupermarketPremise sp;
        if (fromHall) {
            sp = market.getHall();
        } else {
            sp = market.getStorage();
        }
        for (Map.Entry<BaseProduct, Double> pc : prods.entrySet()) {
            BaseProduct currProd = pc.getKey();
            BaseProduct realKey = getSimilar(sp.getProducts(), currProd);
            if (hasProduct(market, fromHall, currProd)) {
                if (sp.getProducts().get(realKey) < pc.getValue()) {
                    removedProducts.put(realKey, -1.0);
                } else {
                    removedProducts.put(realKey, pc.getValue());
                }
            }
        }

        for (Map.Entry<BaseProduct, Double> kv : removedProducts.entrySet()) {
            if (kv.getValue() < 0) {
                sp.getProducts().remove(kv.getKey());
            } else {
                sp.getProducts().put(kv.getKey(), sp.getProducts().get(kv.getKey()) - kv.getValue());
            }
        }
        return removedProducts;
    }

    public BaseProduct getSimilar(Supermarket market, BaseProduct prod) {
        return getSimilar(market.getHall().getProducts(), prod);
    }

    private BaseProduct getSimilar(Map<BaseProduct, Double> prods, BaseProduct exemplar) {
        Class<? extends BaseProduct> cl = exemplar.getClass();
        for(Map.Entry<BaseProduct, Double> kv : prods.entrySet()) {
            if (kv.getKey().getClass().equals(cl)) {
                return kv.getKey();
            }
        }
        return null;
    }

    public void simpleMoveFromStorageToHall(Supermarket market) {
        market.getHall().getProducts().putAll(removeFromSupermarketPremise(market, false,  market.getStorage().getProducts()));
    }

    public void moveFromHallToStorage(Supermarket market, Map<BaseProduct, Double> prods) {
        Map<BaseProduct, Double> movingProds = removeFromSupermarketPremise(market, true,  prods);
        addStorage(market, movingProds);
    }

    public void checkProducts(Supermarket market, int currDate) {
        Map<BaseProduct, Double> forRemove = new HashMap<>();
        for (Map.Entry<BaseProduct, Double> kv : market.getHall().getProducts().entrySet()) {
            if (kv.getKey().getProductionDate() + kv.getKey().getExpDate() > currDate) {
                forRemove.put(kv.getKey(), kv.getValue());
            }
        }
        moveFromHallToStorage(market, forRemove);
        removeFromSupermarketPremise(market, false, forRemove);
    }

    public boolean hasProduct(Supermarket market, boolean isInHall,  BaseProduct prod) {
        Map<BaseProduct, Double> prodsInHall;
        if (isInHall) {
            prodsInHall = market.getHall().getProducts();
        } else {
            prodsInHall = market.getStorage().getProducts();
        }

        BaseProduct p = getSimilar(prodsInHall, prod);
        return p != null;
    }
}
