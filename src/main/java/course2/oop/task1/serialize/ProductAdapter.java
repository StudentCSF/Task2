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

public class ProductAdapter implements JsonDeserializer<BaseProduct>, JsonSerializer<BaseProduct> {
    public BaseProduct deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext context) throws JsonParseException {
        JsonElement elem = jsonElement.getAsJsonObject().get("BaseProduct");
        JsonObject object = elem.getAsJsonObject();
        String productType = context.deserialize(object.getAsJsonPrimitive("name"), String.class);
        switch (productType) {
            case "Хлеб":
                return context.deserialize(elem, Bread.class);
            case "Батон":
                return context.deserialize(elem, Loaf.class);
            case "Порошок":
                return context.deserialize(elem, Powder.class);
            case "Шампунь":
                return context.deserialize(elem, Shampoo.class);
            case "Мыло":
                return context.deserialize(elem, Soap.class);
            case "Пиво":
                return context.deserialize(elem, Beer.class);
            case "Водка":
                return context.deserialize(elem, Vodka.class);
            case "Вино":
                return context.deserialize(elem, Wine.class);
            case "Сок":
                return context.deserialize(elem, Juice.class);
            case "Лимонад":
                return context.deserialize(elem, Lemonade.class);
            case "Вода":
                return context.deserialize(elem, Water.class);
            case "Яблоко":
                return context.deserialize(elem, Apple.class);
            case "Банан":
                return context.deserialize(elem, Banana.class);
            case "Огурец":
                return context.deserialize(elem, Cucumber.class);
            case "Виноград":
                return context.deserialize(elem, Grapes.class);
            case "Лук":
                return context.deserialize(elem, Onion.class);
            case "Апельсин":
                return context.deserialize(elem, Orange.class);
            case "Картофель":
                return context.deserialize(elem, Potato.class);
            case "Помидор":
                return context.deserialize(elem, Tomato.class);
            case "Гречка":
                return context.deserialize(elem, BuckWheat.class);
            case "Конфеты":
                return context.deserialize(elem, Candy.class);
            case "Печенье":
                return context.deserialize(elem, Cookie.class);
            case "Макароны":
                return context.deserialize(elem, Macaroni.class);
            case "Рис":
                return context.deserialize(elem, Rice.class);
            case "Соль":
                return context.deserialize(elem, Salt.class);
            case "Сахар":
                return context.deserialize(elem, Sugar.class);
            case "Вареная колбаса":
                return context.deserialize(elem, BoiledSausage.class);
            case "Мясо":
                return context.deserialize(elem, Meat.class);
            case "Фарш":
                return context.deserialize(elem, MincedMeat.class);
            case "Сосиска":
                return context.deserialize(elem, Sausage.class);
            case "Копченая колбаса":
                return context.deserialize(elem, SmokedSausage.class);
            case "Сливочное масло":
                return context.deserialize(elem, Butter.class);
            case "Сыр":
                return context.deserialize(elem, Cheese.class);
            case "Творог":
                return context.deserialize(elem, Curd.class);
            case "Кефир":
                return context.deserialize(elem, Kefir.class);
            case "Молоко":
                return context.deserialize(elem, Milk.class);
            case "Сметана":
                return context.deserialize(elem, SourCream.class);
            case "Йогурт":
                return context.deserialize(elem, Yogurt.class);
            default:
                System.out.println("Product deserialize error");
        }
        return null;
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
}
