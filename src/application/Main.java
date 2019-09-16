package application;

import maze.Board;
import renderer.GUI;

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

    private Main() {

        board = new Board();
        gui = new GUI(board, this);
        player = new Player(0, 0);

    }

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) player.move(Direction.NORTH, board);
        if (key == KeyEvent.VK_DOWN) player.move(Direction.SOUTH, board);
        if (key == KeyEvent.VK_LEFT) player.move(Direction.WEST, board);
        if (key == KeyEvent.VK_RIGHT) player.move(Direction.EAST, board);

        gui.update();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
