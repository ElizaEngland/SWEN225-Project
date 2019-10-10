package application;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * The Direction class chooses the direction of the current player.
 */
enum Direction {
    NORTH, SOUTH, EAST, WEST;

    //based on code from https://stackoverflow.com/questions/1972392/pick-a-random-value-from-an-enum
    private static final List<Direction> VALUES = Arrays.asList(values());
    private static final Random RANDOM = new Random();

    public static Direction randir()  {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }
}

