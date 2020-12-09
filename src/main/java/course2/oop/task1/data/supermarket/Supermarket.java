package course2.oop.task1.data.supermarket;

import course2.oop.task1.data.buyer.Buyer;
import course2.oop.task1.data.supermarket.premise.Storage;
import course2.oop.task1.data.supermarket.premise.TradeHall;
import org.apache.commons.collections4.keyvalue.DefaultKeyValue;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс, описывающий супермаркет
 */
public class Supermarket {
    private TradeHall hall;
    private Storage storage;
    private List<DefaultKeyValue<Integer, Buyer>> buyersInSupermarket = new ArrayList<DefaultKeyValue<Integer, Buyer>>();


    public Supermarket() {
        this.hall = new TradeHall();
        this.storage = new Storage();
    }

    public List<DefaultKeyValue<Integer, Buyer>> getBuyersInSupermarket() {
        return buyersInSupermarket;
    }

    public void setBuyersInSupermarket(List<DefaultKeyValue<Integer, Buyer>> buyersInSupermarket) {
        this.buyersInSupermarket = buyersInSupermarket;
    }

    public TradeHall getHall() {
        return hall;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setHall(TradeHall hall) {
        this.hall = hall;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
