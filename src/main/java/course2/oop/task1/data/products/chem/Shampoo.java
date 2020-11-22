package course2.oop.task1.data.products.chem;

import course2.oop.task1.data.products.MeasureUnit;

public class Shampoo extends BaseHouseholdChemicals {

    public Shampoo() {
        super(MeasureUnit.pcs);
    }

    @Override
    public String toString() {
        return "Шампунь";
    }
}
