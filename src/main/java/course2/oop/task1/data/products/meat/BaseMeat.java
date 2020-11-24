package course2.oop.task1.data.products.meat;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;

/**
 * Базовы класс для описания мясных продуктов
 */
public abstract class BaseMeat extends BaseProduct {

    protected BaseMeat() {
        super(MeasureUnit.kg);
    }
}
