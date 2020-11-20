package course2.oop.task1.products.milk;

import course2.oop.task1.products.MeasureUnit;

public class Milk extends BaseMilkProducts {
    protected static final MeasureUnit mu = MeasureUnit.liters;

    public Milk() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Молоко";
    }
}
