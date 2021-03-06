package tests;

import application.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class TestApplication {
    private Main instance;

    @BeforeEach
    void setUp() throws Exception {
        try {
            instance = new Main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * MAIN TESTS
     **/

    @Test
    /**
     * Test wont work anymore as we moved from .map to .JSON
     */
    void loadValidLevel() {
//        instance.loadLevel("./src/level" + "1" + ".map");
    }

    @Test
    /**
     * Test wont work anymore as we moved from .map to .JSON
     */
    void loadInvalidLevel() {
//        instance.setFilename("./src/level" + "0" + ".map");
        instance.loadLevel(instance.getFilename());
        fail();
    }

    @Test
    void timer() {
        instance.setMaxTime(3);
        instance.tick();
    }

    @Test
    void checkPaused() {
        // fail();
    }

    /**
     * PLAYER TESTS
     **/
    @Test
    void move() {
        //fail();
    }

    @Test
    void invalidMove() {
        //fail();

    }

    @Test
    void getInventory() {
        //  fail();

    }
}