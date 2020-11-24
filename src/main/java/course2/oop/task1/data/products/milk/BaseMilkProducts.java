package course2.oop.task1.data.products.milk;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;

/**
 * Базовый класс для описания молочных продуктов
 */
public abstract class BaseMilkProducts extends BaseProduct {

    public BaseMilkProducts(double cost, int expDate, int productionDate, MeasureUnit mu) {
        super(cost, expDate, productionDate, mu);
    }

    public BaseMilkProducts() {
        super();
    }

    public BaseMilkProducts(MeasureUnit mu) {
        super(mu);
    }
}
