package course2.oop.task1.products.green_grocery;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

public abstract class BaseGreenGrocery extends BaseProduct {
    protected static final MeasureUnit mu = MeasureUnit.kg;

    public BaseGreenGrocery() {
        super(mu);
    }

}
