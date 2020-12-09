package course2.oop.task1.serialize;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.supermarket.Supermarket;

import java.io.*;

public class SupermarketSerializer {
    private Gson gson;

    public SupermarketSerializer() {
        this.gson = new GsonBuilder()
                .enableComplexMapKeySerialization()
                .registerTypeAdapter(BaseProduct.class, new ProductAdapter())
                .setPrettyPrinting()
                .create();
    }

    public void serialize(Supermarket market, String filename) {
        try {
            FileWriter fw = new FileWriter(new File(filename));
            gson.toJson(market, fw);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Supermarket deserialize(String filename) {
        try {
            FileReader fr = new FileReader(new File(filename));
            return gson.fromJson(fr, Supermarket.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
