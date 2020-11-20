package course2.oop.task1.products.milk;

import course2.oop.task1.products.MeasureUnit;

public class Yogurt extends BaseMilkProducts {
    protected static final MeasureUnit mu = MeasureUnit.liters;

    public Yogurt() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Йогурт";
    }
}
