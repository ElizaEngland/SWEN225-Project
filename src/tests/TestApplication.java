package tests;

import application.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class TestApplication {
    Main instance;
    @BeforeEach
    void setUp() throws Exception {
        try {
            instance = new Main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    void keyPressed() {
    }

    @Test
    void getPlayer() {
        fail();
    }

    @Test
    void tick() {
        fail();
    }

    @Test
    void getTime() {
        fail();
    }

    @Test
    void checkpaused() {
        fail();
    }
}