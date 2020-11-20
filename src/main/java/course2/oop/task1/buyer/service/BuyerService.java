package course2.oop.task1.buyer.service;

import course2.oop.task1.buyer.Buyer;
import course2.oop.task1.buyer.BuyerLimitations;
import course2.oop.task1.products.service.ProductService;
import course2.oop.task1.utils.Randomizer;

import java.util.*;

public class BuyerService {
    private static final Randomizer RDZ = new Randomizer();

    private static final List<BuyerLimitations> BUYER_LIMITATIONS = new ArrayList<>(Arrays.asList(
            BuyerLimitations.CHEM,
            BuyerLimitations.MEAT,
            BuyerLimitations.MILK,
            BuyerLimitations.VaF
    ));

    public void setBuyer(Buyer b) {
        b.setAge(RDZ.random(5, 90));
        b.setShoppingList(new ProductService().createRandomProductsSet(RDZ.random(1, 30), -1));
        b.setAvailableMoney(RDZ.random(100.0, 10000.0));
        createRandomLims(b);
    }

    private void createRandomLims(Buyer b) {
        Set<BuyerLimitations> lims = new HashSet<>();

        int bound = RDZ.random(0, BUYER_LIMITATIONS.size());
        for (int i = 0; i < bound; i++) {
            if (RDZ.random(1, 100) % 3 == 0) {
                lims.add(RDZ.random(BUYER_LIMITATIONS));
            }
        }
        b.setLimitations(lims);
    }
}
