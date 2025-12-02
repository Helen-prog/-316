package lesson_7.enum_2;

import java.util.Random;

public enum Direction {
    TOP, BOTTOM, LEFT, RIGHT;

    private static final Random random = new Random();

    public static Direction randomDirection() {
        Direction[] values = values();
        return values[random.nextInt(values.length)];
    }
}
