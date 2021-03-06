package course2.oop.task1.data.products.green_grocery;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;

/**
 * Базовый класс для описания овощей и фруктов
 */
public abstract class BaseGreenGrocery extends BaseProduct {

    protected BaseGreenGrocery(String name) {
        super(MeasureUnit.kg, name);
    }
}
