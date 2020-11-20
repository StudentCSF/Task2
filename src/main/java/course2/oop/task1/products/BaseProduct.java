package course2.oop.task1.products;

public abstract class BaseProduct {
    protected double cost;
    protected int expDate;
    protected int productionDate;
    protected MeasureUnit mu;

    public BaseProduct() {
    }

    public BaseProduct(MeasureUnit mu) {
        this.mu = mu;
    }

    public BaseProduct(double cost, int expDate, int productionDate, MeasureUnit mu) {
        this.cost = cost;
        this.expDate = expDate;
        this.productionDate = productionDate;
        this.mu = mu;
    }

    public BaseProduct(int productionDate) {
        this.productionDate = productionDate;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double newCost) {
        this.cost = newCost;
    }

    public int getProductionDate() {
        return this.productionDate;
    }

    public int getExpDate() {
        return this.expDate;
    }

    public MeasureUnit getMeasureUnit() {
        return this.mu;
    }

    public void setExpDate(int expDate) {
        this.expDate = expDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }

}
