package course2.oop.task1.data.buyer;

import course2.oop.task1.data.products.BaseProduct;

import java.util.Map;
import java.util.Set;

/**
 * Данный класс описывает покупателя
 */
public class Buyer {
    private Integer age;
    private Double availableMoney;
    private Map<BaseProduct, Double> shoppingList;
    private Set<BuyerLimitations> limitations;

    public Integer getAge() {
        return age;
    }

    public Double getAvailableMoney() {
        return availableMoney;
    }

    public Map<BaseProduct, Double> getShoppingList() {
        return shoppingList;
    }

    public Set<BuyerLimitations> getLimitations() {
        return limitations;
    }

    public void setAvailableMoney(Double availableMoney) {
        this.availableMoney = availableMoney;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setShoppingList(Map<BaseProduct, Double> shoppingList) {
        this.shoppingList = shoppingList;
    }

    public void setLimitations(Set<BuyerLimitations> limitations) {
        this.limitations = limitations;
    }

}
