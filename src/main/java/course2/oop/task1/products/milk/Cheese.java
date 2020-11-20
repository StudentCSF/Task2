package course2.oop.task1.products.milk;

import course2.oop.task1.products.MeasureUnit;

public class Cheese extends BaseMilkProducts {
    protected static final MeasureUnit mu = MeasureUnit.kg;

    public Cheese() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Сыр";
    }
}
