package course2.oop.task1.data.products.chem;

import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.MeasureUnit;

/**
 * Базовый класс для описания товаров бытовой химии
 */
public abstract class BaseHouseholdChemicals extends BaseProduct {

    protected BaseHouseholdChemicals(MeasureUnit mu) {
        super(mu);
    }
}
