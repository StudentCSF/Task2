package course2.oop.task1.supermarket;

import course2.oop.task1.supermarket.premise.Storage;
import course2.oop.task1.supermarket.premise.TradeHall;

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
