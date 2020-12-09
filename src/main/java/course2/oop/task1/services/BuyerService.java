package course2.oop.task1.services;

import com.google.gson.Gson;
import course2.oop.task1.data.buyer.Buyer;
import course2.oop.task1.data.buyer.BuyerLimitations;
import org.apache.commons.lang3.RandomUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Класс для случайной установки параметров для покупателя
 */
public class BuyerService {
//    private Gson gson = new Gson();
    private Integer counter = 0;

    private final EnumSet<BuyerLimitations> buyerLims = EnumSet.allOf(BuyerLimitations.class);

    /**
     * метод, уставанливающий случайные параметры покупателю
     * @param b - покупатель, котрому будут устанавливаться параметры
     */
    public void setBuyer(Buyer b) {
        b.setAge(RandomUtils.nextInt(5, 90));
        b.setShoppingList(new ProductService().createRandomProductsSet(RandomUtils.nextInt(1, 30), -1));
        String str = String.valueOf(RandomUtils.nextDouble(100.0, 10000.0));
        b.setAvailableMoney(Double.parseDouble(str.substring(0, str.indexOf(".") + 3)));
        createRandomLims(b);
    }

    /**
     * метод, генерирующий и устанавливающий случайный набор ограничений покупателя
     * @param b - покупатель
     */
    private void createRandomLims(Buyer b) {
        Set<BuyerLimitations> lims = new HashSet<BuyerLimitations>();

        int bound = RandomUtils.nextInt(0, buyerLims.size());
        for (int i = 0; i < bound; i++) {
            if (RandomUtils.nextInt(1, 100) % 3 == 0) {
                int j = 0;
                int index = RandomUtils.nextInt(0, buyerLims.size());
                for (BuyerLimitations curr : buyerLims) {
                    if (j == index && !lims.contains(curr)) lims.add(curr);
                    j++;
                }
            }
        }
        b.setLimitations(lims);
    }
}
