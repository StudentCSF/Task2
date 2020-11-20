package course2.oop.task1.products.bread;

import course2.oop.task1.products.BaseProduct;
import course2.oop.task1.products.MeasureUnit;

public abstract class BaseBread extends BaseProduct {
    protected static final MeasureUnit mu = MeasureUnit.pcs;

    public BaseBread() {
        super(mu);
    }
}
