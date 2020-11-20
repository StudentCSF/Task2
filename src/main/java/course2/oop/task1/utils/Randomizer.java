package course2.oop.task1.utils;

import java.util.List;
import java.util.Random;

public final class Randomizer {
    private static final Random rnd = new Random();

    public final <T> T random(List<T> list) {
        return list.get(rnd.nextInt(list.size() - 1));
    }

    public final int random(int from, int to) {
        return rnd.nextInt(to - from) + from;
    }

    public final double random(double from, double to) {
        String str = String.valueOf(rnd.nextDouble() * (to - from) + from);
        return Double.parseDouble(str.substring(0, str.indexOf(".") + 3));
    }
}
