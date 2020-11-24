package course2.oop.task1.services;

import course2.oop.task1.data.buyer.Buyer;
import course2.oop.task1.data.buyer.BuyerLimitations;
import course2.oop.task1.utils.Randomizer;

import java.util.*;

/**
 * Класс для случайной установки параметров для покупателя
 */
public class BuyerService {
    private final Randomizer rdz = new Randomizer();
    private final EnumSet<BuyerLimitations> buyerLims = EnumSet.allOf(BuyerLimitations.class);

    /**
     * метод, уставанливающий случайные параметры покупателю
     * @param b - покупатель, котрому будут устанавливаться параметры
     */
    public void setBuyer(Buyer b) {
        b.setAge(rdz.random(5, 90));
        b.setShoppingList(new ProductService().createRandomProductsSet(rdz.random(1, 30), -1));
        b.setAvailableMoney(rdz.random(100.0, 10000.0));
        createRandomLims(b);
    }

    /**
     * метод, генерирующий и устанавливающий случайный набор ограничений покупателя
     * @param b - покупатель
     */
    private void createRandomLims(Buyer b) {
        Set<BuyerLimitations> lims = new HashSet<>();

        int bound = rdz.random(0, buyerLims.size());
        for (int i = 0; i < bound; i++) {
            if (rdz.random(1, 100) % 3 == 0) {
                lims.add(rdz.random(buyerLims));
            }
        }
        b.setLimitations(lims);
    }
}
