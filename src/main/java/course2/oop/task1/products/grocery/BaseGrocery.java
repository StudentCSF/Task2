package course2.oop.task1.products.grocery;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

public abstract class BaseGrocery extends BaseProduct {
    protected static final MeasureUnit mu = MeasureUnit.kg;

    public BaseGrocery() {
        super(mu);
    }
}
