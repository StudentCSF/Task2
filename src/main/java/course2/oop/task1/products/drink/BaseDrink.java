package course2.oop.task1.products.drink;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

public abstract class BaseDrink extends BaseProduct {
    protected static final MeasureUnit mu = MeasureUnit.liters;

    public BaseDrink() {
        super(mu);
    }

}
