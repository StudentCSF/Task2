package course2.oop.task1.services;

import course2.oop.task1.MainServiceRapporteur;
import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.buyer.Buyer;
import course2.oop.task1.data.buyer.BuyerLimitations;
import course2.oop.task1.data.products.chem.BaseHouseholdChemicals;
import course2.oop.task1.data.products.drink.alcohol.BaseAlcohol;
import course2.oop.task1.data.products.green_grocery.BaseGreenGrocery;
import course2.oop.task1.data.products.meat.BaseMeat;
import course2.oop.task1.data.products.milk.BaseMilkProducts;
import course2.oop.task1.data.supermarket.Supermarket;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.keyvalue.DefaultKeyValue;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;

/**
 * Класс, спосбный симулировать работу супермаркета
 */
public class MainService {
    private final SupermarketService supServ;
    private final BuyerService buyServ;
    private final ProductService prodServ;
    private final MainServiceRapporteur rapporteur;

    private int buyersCounter = 1;

    private final List<KeyValue<Integer, Buyer>> buyersInSupermarket = new ArrayList<KeyValue<Integer, Buyer>>();

    public MainService() {
        supServ = new SupermarketService();
        buyServ = new BuyerService();
        prodServ = new ProductService();
        rapporteur = new MainServiceRapporteur();
    }

    /**
     * метод, запускающий симуляцию работы супермаркета
     * @param market - супермаркет
     */
    public void simulate(Supermarket market) {
        int currDate = 0;
        for (int i = 0; i < 10000; i++) {
            int curr = RandomUtils.nextInt(0, 5);
            switch (curr) {
                case 0:
                    Buyer b = new Buyer();
                    buyServ.setBuyer(b);
                    buyerArrived(b);
                    rapporteur.report("Пришел покупатель #" + buyersCounter);
                    buyersCounter++;
                    break;
                case 1:
                    if (!buyersInSupermarket.isEmpty()) {
                        buyerPurchase(market, buyersInSupermarket.get(RandomUtils.nextInt(0, buyersInSupermarket.size())));
                    }
                    break;
                case 2:
                    productsBroughtToSupermarket(market, currDate);
                    rapporteur.report("Привезли товары");
                    break;
                case 3:
                    supServ.checkProducts(market, currDate);
                    rapporteur.report("Персонал проверил товары на годность");
                    break;
                case 4:
                    supServ.simpleMoveFromStorageToHall(market);
                    rapporteur.report("Товары со склада перенесли в торговый зал");
                    break;
                default:
                    continue;
            }
            if (i % 100 == 0) {
                currDate++;
            }
        }
    }

    /**
     * метод, который реализует прибытие покупателя в супермаркет
     * @param b - покупатель
     */
    private void buyerArrived(Buyer b) {
        buyersInSupermarket.add(new DefaultKeyValue<Integer, Buyer>(buyersCounter, b));
    }

    /**
     * метод, который реализует операцию покупки покупателем товаров в супермаркете
     * @param market - супермаркет
     * @param b - покупатель
     */
    private void buyerPurchase(Supermarket market, KeyValue<Integer, Buyer> b) {
        Map<BaseProduct, Double> lp = b.getValue().getShoppingList();
        for (Map.Entry<BaseProduct, Double> kv : lp.entrySet()) {
            if (supServ.hasProduct(market, true, kv.getKey())) {
                if (canPurchase(b, kv.getKey())) {
                    double currCost = kv.getKey().getCost() * kv.getValue();
                    if (currCost < b.getValue().getAvailableMoney()) {
                        BaseProduct realKey = supServ.getSimilar(market, kv.getKey());
                        market.getHall().getProducts().put(realKey, market.getHall().getProducts().get(realKey) - kv.getValue());
                        b.getValue().setAvailableMoney(b.getValue().getAvailableMoney() - currCost);
                        rapporteur.report("Покупатель #" + b.getKey() + " купил " + kv.getValue() + " " + kv.getKey().getMeasureUnit() + " " + kv.getKey());
                    } else {
                        rapporteur.report("У покупателя #" + b.getKey() + " не хватает денег на " + kv.getKey());
                    }
                }
            } else {
                rapporteur.report("Покупатель #" + b.getKey() + " не нашел "+ kv.getKey() + " в магазине");
            }
        }
        buyersInSupermarket.remove(b);
    }

    /**
     * метод, проверяющий возможность совершить покупку товапа покупателем
     * @param b - покупатель
     * @param p - продукт, который пытаются купить
     * @return истина, если покупатель может совершить покупку, в противном случае ложь
     */
    private boolean canPurchase(KeyValue<Integer, Buyer> b, BaseProduct p) {
        if (p instanceof BaseAlcohol && b.getValue().getAge() < 18) {
            rapporteur.report("Покупатель #" + b.getKey() + " пытается купить " + p + ", но ему не продают в силу возраста");
            return false;
        }
        Set<BuyerLimitations> l = b.getValue().getLimitations();
        if (p instanceof BaseMeat && l.contains(BuyerLimitations.MEAT)) {
            rapporteur.report("Покупатель #" + b.getKey() + " не будет покупать " + p + ", т.к. у него его непереносимость");
            return false;
        }
        if (p instanceof BaseMilkProducts && l.contains(BuyerLimitations.MILK)) {
            rapporteur.report("Покупатель #" + b.getKey() + " не будет покупать " + p + ", т.к. у него его непереносимость");
            return false;
        }
        if (p instanceof BaseHouseholdChemicals && l.contains(BuyerLimitations.CHEM)) {
            rapporteur.report("Покупатель #" + b.getKey() + " не будет покупать " + p + ", т.к. у него на неё аллергия");
            return false;
        }
        if (p instanceof BaseGreenGrocery && l.contains(BuyerLimitations.VaF)) {
            rapporteur.report("Покупатель #" + b.getKey() + " не будет покупать " + p + ", т.к. у него непереносимость клетчатки");
            return false;
        }
        return true;
    }

    /**
     * метод реализующий привоз товаров на склда супермаркета
     * @param market - маркет
     * @param date - дата привоза, которая считается эквивалентной дате их производства
     */
    private void productsBroughtToSupermarket(Supermarket market, int date) {
        Map<BaseProduct, Double> brought = prodServ.createRandomProductsSet(RandomUtils.nextInt(300, 1000), date);
        supServ.addStorage(market, brought);
    }
}
