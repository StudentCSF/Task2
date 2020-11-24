package course2.oop.task1.data.supermarket;

import course2.oop.task1.data.supermarket.premise.Storage;
import course2.oop.task1.data.supermarket.premise.TradeHall;

/**
 * Класс, описывающий супермаркет
 */
public class Supermarket {
    private final TradeHall hall;
    private final Storage storage;

    public Supermarket() {
        this.hall = new TradeHall();
        this.storage = new Storage();
    }

    public TradeHall getHall() {
        return hall;
    }

    public Storage getStorage() {
        return storage;
    }
}
