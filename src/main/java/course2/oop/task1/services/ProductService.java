package course2.oop.task1.services;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;
import course2.oop.task1.data.products.green_grocery.*;
import course2.oop.task1.data.products.grocery.*;
import course2.oop.task1.data.products.meat.*;
import course2.oop.task1.data.products.milk.*;
import course2.oop.task1.data.products.drink.Juice;
import course2.oop.task1.data.products.drink.Lemonade;
import course2.oop.task1.data.products.drink.Water;
import course2.oop.task1.data.products.drink.alcohol.Beer;
import course2.oop.task1.data.products.drink.alcohol.Vodka;
import course2.oop.task1.data.products.drink.alcohol.Wine;
import course2.oop.task1.data.products.bread.Bread;
import course2.oop.task1.data.products.bread.Loaf;
import course2.oop.task1.data.products.chem.Powder;
import course2.oop.task1.data.products.chem.Shampoo;
import course2.oop.task1.data.products.chem.Soap;
import course2.oop.task1.utils.Randomizer;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, способный устанавливать случайные параметры проудкту
 */
public class ProductService {

    private final Randomizer rdz = new Randomizer();

    /**
     * метод, создающий случайный набор продуктов
     * @param bound - количество генерируемых товаров
     * @param currDate - актуальная дата
     * @return набор продуктов
     */
    public Map<BaseProduct, Double> createRandomProductsSet(int bound, int currDate)  {
        Map<BaseProduct, Double> res = new HashMap<>();

        for (int i = 0; i < bound; i++) {
            BaseProduct prod  = randomProduct(rdz.random(0, 38));
            if (prod == null) continue;
            setRandomProduct(prod, currDate);
            double count;
            if (bound > 100) {
                count = prod.getMeasureUnit() == MeasureUnit.pcs ? rdz.random(10, 100) : rdz.random(10.0, 100.0);
            } else {
                count = prod.getMeasureUnit() == MeasureUnit.pcs ? rdz.random(1, 10) : rdz.random(0.1, 10.0);
            }
            res.put(prod, count);
        }
        return res;
    }

    /**
     * методд, устанавливающий случайные параметры продукту
     * @param prod - продукт
     * @param date - дата производства
     */
    private void setRandomProduct(BaseProduct prod, int date) {
        prod.setCost(rdz.random(20.0, 1000.0));
        prod.setExpDate(rdz.random(3, 100));
        if (date > -1) {
            prod.setProductionDate(date);
        }
    }

    /**
     * метод, возвращающий случайный экземпляр класса, наслдующегося от BaseProduct
     * @param n - случайное число от 0 до 37(включительно)
     * @return случайный экземпляр продукта
     */
    private BaseProduct randomProduct(int n) {
        switch (n) {
            case 0: return new Beer();
            case 1: return new Vodka();
            case 2: return new Wine();
            case 3: return new Bread();
            case 4: return new Loaf();
            case 5: return new Powder();
            case 6: return new Shampoo();
            case 7: return new Soap();
            case 8: return new Apple();
            case 9: return new Banana();
            case 10: return new Cucumber();
            case 11: return new Grapes();
            case 12: return new Orange();
            case 13: return new Orion();
            case 14: return new Potato();
            case 15: return new Tomato();
            case 16: return new BuckWheat();
            case 17: return new Candy();
            case 18: return new Cookie();
            case 19: return new Macaroni();
            case 20: return new Rice();
            case 21: return new Salt();
            case 22: return new Sugar();
            case 23: return new BoiledSausage();
            case 24: return new Meat();
            case 25: return new MincedMeat();
            case 26: return new Sausages();
            case 27: return new SmokedSausage();
            case 28: return new Butter();
            case 29: return new Cheese();
            case 30: return new Curd();
            case 31: return new Kefir();
            case 32: return new Milk();
            case 33: return new SourCream();
            case 34: return new Yogurt();
            case 35: return new Juice();
            case 36: return new Lemonade();
            case 37: return new Water();
            default : return null;
        }
    }
}
