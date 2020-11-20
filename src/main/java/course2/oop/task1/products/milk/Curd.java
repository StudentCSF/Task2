package course2.oop.task1.products.milk;

import course2.oop.task1.products.MeasureUnit;

public class Curd extends BaseMilkProducts {
    protected static final MeasureUnit mu = MeasureUnit.kg;

    public Curd() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Творог";
    }
}
