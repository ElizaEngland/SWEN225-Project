package application;

import org.junit.jupiter.api.MethodOrderer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

enum Direction {
    NORTH, SOUTH, EAST, WEST;

    // This method is based off an example from https://stackoverflow.com/questions/1972392/pick-a-random-value-from-an-enum
    private static final List<Direction> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static Direction RanDir()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

}

