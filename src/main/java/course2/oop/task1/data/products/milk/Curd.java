package course2.oop.task1.data.products.milk;

import course2.oop.task1.data.products.MeasureUnit;

public class Curd extends BaseMilkProducts {

    public Curd() {
        super(MeasureUnit.kg);
    }

    @Override
    public String toString() {
        return "Творог";
    }
}
