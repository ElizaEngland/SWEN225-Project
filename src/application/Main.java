package application;

import maze.Board;
import renderer.GUI;
import renderer.GUIPause;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

/**
 * Main class for Chip's Challenge.
 */
public class Main implements KeyListener {

    public static final int COLS = 9;
    public static final int ROWS = 9;
    public static int MAX_TREASURE = 0;

    private static Board board;
    private static GUI gui;
    private static Player player;
    private boolean running = false;
    private static boolean paused = false;
    private static int time = 0;
    private File file;

    private static int currLevel;

    private Main() {
        currLevel = 1;
        loadLevel("./src/level" + getCurrLevel() + ".map");

        gui = new GUI(board, this);

        tick();
    }

    public void loadLevel(String file) {
        board = new Board(new File(file));
        player = new Player(board.getStartX(), board.getStartY());
        board.update(board.getStartX(), board.getStartY(), board.getStartX(), board.getStartY());
        MAX_TREASURE = board.getTreasureCount();
    }

    /**
     * Handles key press events and makes the corresponding changes to the game.
     *
     * @param e The key which was pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {

        if (paused) return;

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) player.move(Direction.NORTH, board);
        if (key == KeyEvent.VK_DOWN) player.move(Direction.SOUTH, board);
        if (key == KeyEvent.VK_LEFT) player.move(Direction.WEST, board);
        if (key == KeyEvent.VK_RIGHT) player.move(Direction.EAST, board);
        if (key == KeyEvent.VK_SPACE) new GUIPause();

        if (key == KeyEvent.VK_X && e.isControlDown()) System.exit(0);
        if (key == KeyEvent.VK_S && e.isControlDown()) gui.savePopup();
        if (key == KeyEvent.VK_L && e.isControlDown()) gui.loadPopup();
        if (key == KeyEvent.VK_R && e.isControlDown()) System.out.println("Resume");
        if (key == KeyEvent.VK_P && e.isControlDown()) System.out.println("Start a game at the last unfinished level");
        if (key == KeyEvent.VK_1 && e.isControlDown()) System.out.println("Start a new game at level 1");

        gui.updateBoard();

    }

    public static Player getPlayer() {
        return player;
    }

    /**
     * Main loop of the game
     */
    public void tick() {
        running = true;
        long previous = System.nanoTime();
        long current;
        while (running) {
            if (!paused) {
                current = System.nanoTime();
                if (current - previous > 1000000000) {
                    previous = current;
                    time++;
                    gui.updatePanel();
                }
                if (time == 100) {
                    running = false;
                    gui.GameOver();
                }
            }
        }
    }

    public static int getTime() {
        return time;
    }

    public static void setPaused(boolean paused) {
        Main.paused = paused;
    }

    public static int getCurrLevel() {
        return currLevel;
    }

    public static void main(String[] args) {
        new Main();
    }

    // Unused methods:

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
