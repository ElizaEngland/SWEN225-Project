package tests;

import application.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

/**MAIN TESTS **/

    @Test
    void loadValidLevel() {
        instance.loadLevel("./src/level" + "1" + ".map");
    }

    @Test
    void loadInvalidLevel() {
        instance.setFilename("./src/level" + "0" + ".map");
        instance.loadLevel(instance.getFilename());
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

    /**PLAYER TESTS **/
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