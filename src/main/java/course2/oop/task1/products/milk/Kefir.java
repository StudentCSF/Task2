package course2.oop.task1.products.milk;

import course2.oop.task1.products.MeasureUnit;

public class Kefir extends BaseMilkProducts {
    protected static final MeasureUnit mu = MeasureUnit.liters;

    public Kefir() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Кефир";
    }
}
