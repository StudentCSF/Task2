package course2.oop.task1;

import course2.oop.task1.supermarket.Supermarket;

public class Main {

    public static void main(String[] args) {
        Supermarket market = new Supermarket();
        MainService ms = new MainService();
        ms.simulate(market);
    }
}
