package application;

import maze.Board;
import renderer.GUI;
import sun.awt.SunHints;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Main class for Chip's Challenge.
 */
public class Main implements KeyListener {

    public static final int COLS = 9;
    public static final int ROWS = 9;

    private final Board board;
    private final GUI gui;
    private final Player player;
    private boolean hasWon = false;

    private Main() {

        board = new Board();
        gui = new GUI(board, this);
        player = new Player(5, 5);

        while (!hasWon) {

        }

        // end the level

    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("key pressed");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
