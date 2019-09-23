package application;

import maze.Board;
import renderer.GUI;
import renderer.GUIPause;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Main class for Chip's Challenge.
 */
public class Main implements KeyListener {

    public static final int COLS = 9;
    public static final int ROWS = 9;
    public static int MAX_TREASURE = 0;

    private final Board board;
    private final GUI gui;
    private static Player player;
    private boolean running = false;
    private static boolean paused = false;
    private static int time = 0;

    private Main() {
        board = new Board();
        player = new Player(5, 5);
        gui = new GUI(board, this);
        MAX_TREASURE = board.getTreasureCount();
        board.update(5, 5, 5, 5); // FIXME: 16/09/2019 Should be done a bit cleaner
        gui.updateBoard();
        tick();
    }

    /**
     * Handles key press events and makes the corresponding changes to the game.
     *
     * @param e The key which was pressed
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) player.move(Direction.NORTH, board);
        if (key == KeyEvent.VK_DOWN) player.move(Direction.SOUTH, board);
        if (key == KeyEvent.VK_LEFT) player.move(Direction.WEST, board);
        if (key == KeyEvent.VK_RIGHT) player.move(Direction.EAST, board);
        if (key == KeyEvent.VK_SPACE) {
            setPaused(true);
            new GUIPause();
        }

        if (key == KeyEvent.VK_X && e.isControlDown()) System.exit(0);
        if (key == KeyEvent.VK_S && e.isControlDown()) System.out.println("Save");
        if (key == KeyEvent.VK_R && e.isControlDown()) System.out.println("Resume");
        if (key == KeyEvent.VK_P && e.isControlDown()) System.out.println("Start a new game at the last unfinished level");
        if (key == KeyEvent.VK_1 && e.isControlDown()) System.out.println("Start a new game at level 1");

        gui.updateBoard();
    }

    public static Player getPlayer() {
        return player;
    }

    /**
     * Main loop of the game
     */
    public void tick(){
        running = true;
        long previous = System.nanoTime();
        long current;
        while(running) {
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
