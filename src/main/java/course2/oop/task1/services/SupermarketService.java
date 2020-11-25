package course2.oop.task1.services;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.supermarket.Supermarket;
import course2.oop.task1.data.supermarket.premise.SupermarketPremise;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, симулирующий работу персонала супермаркета
 */
public class SupermarketService {
    /**
     * метод, заполняющий склад товарами
     * @param market - супермаркет
     * @param prods - набор продуктов
     */
    public void addStorage(Supermarket market, Map<BaseProduct, Double> prods) {
        market.getStorage().getProducts().putAll(prods);
    }

    /**
     * метод, удаляющий определенный набор продуктов из помещения супермаркета
     * @param market - супермаркет
     * @param fromHall - флаг, сигнализирующий из тороговго зала или со склада надо удалить
     * @param prods - удаляемый набор проуктов
     * @return удаленный набор продуктов
     */
    private Map<BaseProduct, Double> removeFromSupermarketPremise(Supermarket market, boolean fromHall,  Map<BaseProduct, Double> prods) {
        Map<BaseProduct, Double> removedProducts = new HashMap<BaseProduct, Double>();

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

    /**
     * метод возвращающий аналогичный товар искомому
     * @param market - супермаркет
     * @param prod - искомый продукт
     * @return аналог искомого продукта
     */
    public BaseProduct getSimilar(Supermarket market, BaseProduct prod) {
        return getSimilar(market.getHall().getProducts(), prod);
    }

    /**
     * метод, который среди набора товаров ищет аналог искомому
     * @param prods - набор товаров, где идет поиск
     * @param exemplar - искомый товар
     * @return аналог искомого товара
     */
    private BaseProduct getSimilar(Map<BaseProduct, Double> prods, BaseProduct exemplar) {
        Class<? extends BaseProduct> cl = exemplar.getClass();
        for(Map.Entry<BaseProduct, Double> kv : prods.entrySet()) {
            if (kv.getKey().getClass().equals(cl)) {
                return kv.getKey();
            }
        }
        return null;
    }

    /**
     * метод, который переносит все товара со склада в торговый зал
     * @param market - супермаркет
     */
    public void simpleMoveFromStorageToHall(Supermarket market) {
        market.getHall().getProducts().putAll(removeFromSupermarketPremise(market, false,  market.getStorage().getProducts()));
    }

    /**
     * метод который изымает товары из торгового зала и переносящий товары на склад
     * @param market - супермаркет
     * @param prods - набор изымаемых продуктов
     */
    public void moveFromHallToStorage(Supermarket market, Map<BaseProduct, Double> prods) {
        Map<BaseProduct, Double> movingProds = removeFromSupermarketPremise(market, true,  prods);
        addStorage(market, movingProds);
    }

    /**
     * метод, оуществляющий проверку товаров на годность и отправляющий негодные товары на склад
     * @param market - супермаркет
     * @param currDate - актуальная дата
     */
    public void checkProducts(Supermarket market, int currDate) {
        Map<BaseProduct, Double> forRemove = new HashMap<BaseProduct, Double>();
        for (Map.Entry<BaseProduct, Double> kv : market.getHall().getProducts().entrySet()) {
            if (kv.getKey().getProductionDate() + kv.getKey().getExpDate() > currDate) {
                forRemove.put(kv.getKey(), kv.getValue());
            }
        }
        moveFromHallToStorage(market, forRemove);
        removeFromSupermarketPremise(market, false, forRemove);
    }

    /**
     * метод, проверяющий есть ли аналог товара в супермаркете
     * @param market - супермаркет
     * @param isInHall - где искать: на складе или в торговом зале
     * @param prod - искомый товар
     * @return истина, если есть товар, ложь в противном случае
     */
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
