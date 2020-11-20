package course2.oop.task1.products.chem;

import course2.oop.task1.products.MeasureUnit;

public class Powder extends BaseHouseholdChemicals {
    private static final MeasureUnit mu = MeasureUnit.kg;

    public Powder() {
        super(mu);
    }

    @Override
    public String toString() {
        return "Порошок";
    }
}
