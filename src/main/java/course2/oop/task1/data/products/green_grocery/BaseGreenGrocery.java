package course2.oop.task1.data.products.green_grocery;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;

public abstract class BaseGreenGrocery extends BaseProduct {

    protected BaseGreenGrocery() {
        super(MeasureUnit.kg);
    }
}
