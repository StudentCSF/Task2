package course2.oop.task1.data.products.drink;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;

public abstract class BaseDrink extends BaseProduct {

    protected BaseDrink() {
        super(MeasureUnit.liters);
    }
}
