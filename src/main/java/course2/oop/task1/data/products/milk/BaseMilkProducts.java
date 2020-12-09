package course2.oop.task1.data.products.milk;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;

/**
 * Базовый класс для описания молочных продуктов
 */
public abstract class BaseMilkProducts extends BaseProduct {

    protected BaseMilkProducts(Double cost, Integer expDate, Integer productionDate, MeasureUnit mu) {
        super(cost, expDate, productionDate, mu);
    }

    protected BaseMilkProducts() {
        super();
    }

    protected BaseMilkProducts(MeasureUnit mu, String name) {
        super(mu, name);
    }
}
