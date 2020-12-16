package course2.oop.task1.data.products;

/**
 * Данный класс является самым общим (родительским) классом для всех продуктов
 */
public abstract class BaseProduct {
    protected Double cost;
    protected Integer expDate;
    protected Integer productionDate;
    protected MeasureUnit mu;
    protected String name;

    protected BaseProduct() {
    }

    protected BaseProduct(MeasureUnit mu, String name) {
        this.mu = mu;
        this.name = name;
    }

    protected BaseProduct(Double cost, Integer expDate, Integer productionDate, MeasureUnit mu) {
        this.cost = cost;
        this.expDate = expDate;
        this.productionDate = productionDate;
        this.mu = mu;
    }

    protected BaseProduct(int productionDate) {
        this.productionDate = productionDate;
    }

    public Double getCost() {
        return this.cost;
    }

    public void setCost(Double newCost) {
        this.cost = newCost;
    }

    public Integer getProductionDate() {
        return this.productionDate;
    }

    public Integer getExpDate() {
        return this.expDate;
    }

    public MeasureUnit getMeasureUnit() {
        return this.mu;
    }

    public void setExpDate(Integer expDate) {
        this.expDate = expDate;
    }

    public void setProductionDate(Integer productionDate) {
        this.productionDate = productionDate;
    }

    public MeasureUnit getMu() {
        return mu;
    }

    public void setMu(MeasureUnit mu) {
        this.mu = mu;
    }


    @Override
    public String toString() {
        return this.name;
    }
}
