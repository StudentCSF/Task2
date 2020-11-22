package course2.oop.task1.utils;

import java.util.Collection;
import java.util.List;
import java.util.Random;

public final class Randomizer {
    private final Random rnd = new Random();

    public final <T> T random(Collection<T> list)
    {
        int i = 0;
        int r = rnd.nextInt(list.size());
        for (T v : list) {
            if (i == r) return v;
            i++;
        }
        return null;
    }

    public final int random(int from, int to) {
        return rnd.nextInt(to - from) + from;
    }

    public final double random(double from, double to) {
        String str = String.valueOf(rnd.nextDouble() * (to - from) + from);
        return Double.parseDouble(str.substring(0, str.indexOf(".") + 3));
    }
}
