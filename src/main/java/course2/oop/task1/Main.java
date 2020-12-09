package course2.oop.task1;

import course2.oop.task1.data.supermarket.Supermarket;
import course2.oop.task1.services.MainService;

import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        Supermarket market = new Supermarket();
        MainService ms = new MainService();
        ms.simulate(market);
    }
}
