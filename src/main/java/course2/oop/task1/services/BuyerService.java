package course2.oop.task1.services;

import course2.oop.task1.data.buyer.Buyer;
import course2.oop.task1.data.buyer.BuyerLimitations;
import course2.oop.task1.utils.Randomizer;

import java.util.*;

public class BuyerService {
    private final Randomizer rdz = new Randomizer();
    private final EnumSet<BuyerLimitations> buyerLims = EnumSet.allOf(BuyerLimitations.class);

    public void setBuyer(Buyer b) {
        b.setAge(rdz.random(5, 90));
        b.setShoppingList(new ProductService().createRandomProductsSet(rdz.random(1, 30), -1));
        b.setAvailableMoney(rdz.random(100.0, 10000.0));
        createRandomLims(b);
    }

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
