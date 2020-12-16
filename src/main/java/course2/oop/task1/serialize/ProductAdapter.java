package course2.oop.task1.serialize;

import com.google.gson.*;
import course2.oop.task1.data.products.BaseProduct;
import course2.oop.task1.data.products.bread.Bread;
import course2.oop.task1.data.products.bread.Loaf;
import course2.oop.task1.data.products.chem.Powder;
import course2.oop.task1.data.products.chem.Shampoo;
import course2.oop.task1.data.products.chem.Soap;
import course2.oop.task1.data.products.drink.Juice;
import course2.oop.task1.data.products.drink.Lemonade;
import course2.oop.task1.data.products.drink.Water;
import course2.oop.task1.data.products.drink.alcohol.Beer;
import course2.oop.task1.data.products.drink.alcohol.Vodka;
import course2.oop.task1.data.products.drink.alcohol.Wine;
import course2.oop.task1.data.products.green_grocery.*;
import course2.oop.task1.data.products.grocery.*;
import course2.oop.task1.data.products.meat.*;
import course2.oop.task1.data.products.milk.*;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class ProductAdapter implements JsonDeserializer<BaseProduct>, JsonSerializer<BaseProduct> {
    private Map<String, Class<? extends BaseProduct>> map;

    public ProductAdapter() {
        setMap();
    }



    public BaseProduct deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonElement elem = jsonElement.getAsJsonObject().get("BaseProduct");
        JsonObject object = elem.getAsJsonObject();
        String productType = context.deserialize(object.getAsJsonPrimitive("name"), String.class);
        return context.deserialize(elem, map.get(productType));
    }

    public JsonElement serialize(BaseProduct product, Type type, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        JsonElement elem = null;
        switch (product.toString()) {
            case "Хлеб":
                Bread bread = (Bread) product;
                elem = context.serialize(bread);
                break;
            case "Батон":
                Loaf loaf = (Loaf) product;
                elem = context.serialize(loaf);
                break;
            case "Порошок":
                Powder powder = (Powder) product;
                elem = context.serialize(powder);
                break;
            case "Шампунь":
                Shampoo shampoo = (Shampoo) product;
                elem = context.serialize(shampoo);
                break;
            case "Мыло":
                Soap soap = (Soap) product;
                elem = context.serialize(soap);
                break;
            case "Пиво":
                Beer beer = (Beer) product;
                elem = context.serialize(beer);
                break;
            case "Водка":
                Vodka vodka = (Vodka) product;
                elem = context.serialize(vodka);
                break;
            case "Вино":
                Wine wine = (Wine) product;
                elem = context.serialize(wine);
                break;
            case "Сок":
                Juice juice = (Juice) product;
                elem = context.serialize(juice);
                break;
            case "Лимонад":
                Lemonade lemonade = (Lemonade) product;
                elem = context.serialize(lemonade);
                break;
            case "Вода":
                Water water = (Water) product;
                elem = context.serialize(water);
                break;
            case "Яблоко":
                Apple apple = (Apple) product;
                elem = context.serialize(apple);
                break;
            case "Банан":
                Banana banana = (Banana) product;
                elem = context.serialize(banana);
                break;
            case "Огурец":
                Cucumber cucumber = (Cucumber) product;
                elem = context.serialize(cucumber);
                break;
            case "Виноград":
                Grapes grapes = (Grapes) product;
                elem = context.serialize(grapes);
                break;
            case "Лук":
                Onion onion = (Onion) product;
                elem = context.serialize(onion);
                break;
            case "Апельсин":
                Orange orange = (Orange) product;
                elem = context.serialize(orange);
                break;
            case "Картофель":
                Potato potato = (Potato) product;
                elem = context.serialize(potato);
                break;
            case "Помидор":
                Tomato tomato = (Tomato) product;
                elem = context.serialize(tomato);
                break;
            case "Гречка":
                BuckWheat buckWheat = (BuckWheat) product;
                elem = context.serialize(buckWheat);
                break;
            case "Конфеты":
                Candy candy = (Candy) product;
                elem = context.serialize(candy);
                break;
            case "Печенье":
                Cookie cookie = (Cookie) product;
                elem = context.serialize(cookie);
                break;
            case "Макароны":
                Macaroni macaroni = (Macaroni) product;
                elem = context.serialize(macaroni);
                break;
            case "Рис":
                Rice rice = (Rice) product;
                elem = context.serialize(rice);
                break;
            case "Соль":
                Salt salt = (Salt) product;
                elem = context.serialize(salt);
                break;
            case "Сахар":
                Sugar sugar = (Sugar) product;
                elem = context.serialize(sugar);
                break;
            case "Вареная колбаса":
                BoiledSausage boiledSausage = (BoiledSausage) product;
                elem = context.serialize(boiledSausage);
                break;
            case "Мясо":
                Meat meat = (Meat) product;
                elem = context.serialize(meat);
                break;
            case "Фарш":
                MincedMeat mincedMeat = (MincedMeat) product;
                elem = context.serialize(mincedMeat);
                break;
            case "Сосиска":
                Sausage sausage = (Sausage) product;
                elem = context.serialize(sausage);
                break;
            case "Копченая колбаса":
                SmokedSausage smokedSausage = (SmokedSausage) product;
                elem = context.serialize(smokedSausage);
                break;
            case "Сливочное масло":
                Butter butter = (Butter) product;
                elem = context.serialize(butter);
                break;
            case "Сыр":
                Cheese cheese = (Cheese) product;
                elem = context.serialize(cheese);
                break;
            case "Творог":
                Curd curd = (Curd) product;
                elem = context.serialize(curd);
                break;
            case "Кефир":
                Kefir kefir = (Kefir) product;
                elem = context.serialize(kefir);
                break;
            case "Молоко":
                Milk milk = (Milk) product;
                elem = context.serialize(milk);
                break;
            case "Сметана":
                SourCream sourCream = (SourCream) product;
                elem = context.serialize(sourCream);
                break;
            case "Йогурт":
                Yogurt yogurt = (Yogurt) product;
                elem = context.serialize(yogurt);
                break;
            default:
                System.out.println("BaseProduct serialize error");
        }
        result.add("BaseProduct", elem);
        return result;
    }

    private void setMap() {
        this.map = new HashMap<>();
        map.put("Хлеб", Bread.class);
        map.put("Йогурт", Yogurt.class);
        map.put("Сметана", SourCream.class);
        map.put("Молоко", Milk.class);
        map.put("Кефир", Kefir.class);
        map.put("Творог", Curd.class);
        map.put("Сыр", Cheese.class);
        map.put("Сливочное масло", Butter.class);
        map.put("Копченая колбаса", SmokedSausage.class);
        map.put("Сосиска", Sausage.class);
        map.put("Батон", Loaf.class);
        map.put("Порошок", Powder.class);
        map.put("Шампунь", Shampoo.class);
        map.put("Мыло", Soap.class);
        map.put("Сок", Juice.class);
        map.put("Лимонад", Lemonade.class);
        map.put("Вода", Water.class);
        map.put("Пиво", Beer.class);
        map.put("Водка", Vodka.class);
        map.put("Вино", Wine.class);
        map.put("Яблоко", Apple.class);
        map.put("Банан", Banana.class);
        map.put("Огурец", Cucumber.class);
        map.put("Виноград", Grapes.class);
        map.put("Лук", Onion.class);
        map.put("Апельсин", Orange.class);
        map.put("Помидор", Tomato.class);
        map.put("Картофель", Potato.class);
        map.put("Гречка", BuckWheat.class);
        map.put("Конфеты", Candy.class);
        map.put("Печенье", Cookie.class);
        map.put("Макароны", Macaroni.class);
        map.put("Рис", Rice.class);
        map.put("Соль", Salt.class);
        map.put("Сахар", Sugar.class);
        map.put("Вареная колбаса", BoiledSausage.class);
        map.put("Мясо", Meat.class);
        map.put("Фарш", MincedMeat.class);
    }
}
