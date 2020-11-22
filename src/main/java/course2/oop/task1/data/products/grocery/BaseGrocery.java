package course2.oop.task1.data.products.grocery;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;

public abstract class BaseGrocery extends BaseProduct {

    protected BaseGrocery() {
        super(MeasureUnit.kg);
    }
}
