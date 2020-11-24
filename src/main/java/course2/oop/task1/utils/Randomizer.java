package course2.oop.task1.utils;

import java.util.Collection;
import java.util.Random;

/**
 * Утилитный класс для рандомайзинга
 */
public final class Randomizer {
    private final Random rnd = new Random();

    /**
     * метод, возвращающий случайный элемент из переданной коллекции
     * @param collection - коллекция
     * @param <T> - обобщенный параметр
     * @return случайный элемент коллекции
     */
    public final <T> T random(Collection<T> collection)
    {
        int i = 0;
        int r = rnd.nextInt(collection.size());
        for (T v : collection) {
            if (i == r) return v;
            i++;
        }
        return null;
    }

    /**
     * метод, возвращающий случайное целочисленное число из заданного диапазона (верхний предел невключительно)
     * @param from - нижний предел
     * @param to - верхний предел
     * @return случайное целочисленное число из диапазона
     */
    public final int random(int from, int to) {
        return rnd.nextInt(to - from) + from;
    }

    /**
     * метод, возвращающий случайное вещественное число из заданного диапазона
     * @param from - нижний предел
     * @param to - верхний предел
     * @return случайное вещественное число из диапазона
     */
    public final double random(double from, double to) {
        String str = String.valueOf(rnd.nextDouble() * (to - from) + from);
        return Double.parseDouble(str.substring(0, str.indexOf(".") + 3));
    }
}
