package course2.oop.task1.data.products.bread;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;

public abstract class BaseBread extends BaseProduct {

    protected BaseBread() {
        super(MeasureUnit.pcs);
    }
}
