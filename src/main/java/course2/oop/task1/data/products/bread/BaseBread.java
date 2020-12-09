package course2.oop.task1.data.products.bread;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;

/**
 * Базовый класс для описания хлебобулочных изделий
 */
public abstract class BaseBread extends BaseProduct {

    protected BaseBread(String name) {
        super(MeasureUnit.pcs, name);
    }
}
