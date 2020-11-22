package course2.oop.task1.data.products.milk;

import course2.oop.task1.data.products.MeasureUnit;

public class Yogurt extends BaseMilkProducts {

    public Yogurt() {
        super(MeasureUnit.liters);
    }

    @Override
    public String toString() {
        return "Йогурт";
    }
}
