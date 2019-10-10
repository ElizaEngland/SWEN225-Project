package application;

import maze.Board;
import renderer.GUI;
import renderer.GUIPause;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Main class for Chip's Challenge.
 *
 * @author - Ben Robertson, Eliza England, Ethan King, Jacqueline Dong, Jay Patel, Mason Yi
 */

public class Main implements KeyListener {

    public static final int WINDOW_ROWS = 9;
    public static final int WINDOW_COLS = 9;
    public static int COLS;
    public static int ROWS;
    public static int MAX_TREASURE = 0;

    private static Board board;
    private static GUI gui;
    private static Player player;
    private static boolean paused = false;
    private static int time = 0;
    public static int currentLevel = 1;
    public static int maxTime = 60;
    private static String filename;

    /**
     * Initialises a new game and loads the level.
     */
    private void init() {
        gui = new GUI(this);
        filename = "./savedGame/level" + currentLevel + ".json";
        loadLevel(filename);
        tick();
    }

    /**
     * Loads the level into Chip's Challenge, setting up the Board, Player and treasure.
     *
     * @param file The path of the level file.
     */
    public static void loadLevel(String file) {
        try {
            board = new Board(file);
            player = new Player(board.getStartX(), board.getStartY(), board);
            MAX_TREASURE = board.getTreasureCount();
            gui.setBoard(board);
            gui.updateOnMove();
            time = 0;
            System.out.println("TIMETIMEtime = " + time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles key press events and makes the corresponding changes to the game.
     *
     * @param e The key which was pressed.
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

        if (key == KeyEvent.VK_X && e.isControlDown()) Runtime.getRuntime().exit(0);
        if (key == KeyEvent.VK_S && e.isControlDown()) {
            setPaused(true);
            gui.savePopup();
            setPaused(false);
        }
        if (key == KeyEvent.VK_L && e.isControlDown()) {
            setPaused(true);
            gui.loadPopup();
            setPaused(false);
        }
        if (key == KeyEvent.VK_R && e.isControlDown()) {
            System.out.println("unpaused");
            Main.setPaused(false);
        }
        if (key == KeyEvent.VK_P && e.isControlDown()) loadLevel("./savedGame/level" + getCurrentLevel() + ".json");
        if (key == KeyEvent.VK_1 && e.isControlDown()) {
            loadLevel("./savedGame/level1.json");
            setCurrentLevel(1);
        }
        if (key == KeyEvent.VK_2 && e.isControlDown()) {
            loadLevel("./savedGame/level2.json");
            setCurrentLevel(2);
        }

        gui.updateOnMove();

    }


    /**
     * Main loop of the game.
     */
    public void tick() {
        long previous = System.nanoTime();
        long current;
        while (true) {
            if (!paused) {
                current = System.nanoTime();
                if (current - previous > 1000000000) {
                    previous = current;
                    if (Player.getPrisonSentence() >= 0) {
                        int timeleft = Player.getPrisonSentence();
                        timeleft -= 1;
                        Player.setPrisonSentence(timeleft);
                    }
                    time++;
                    try {
                        board.updateEnemies();
                        gui.updateOnTick();
                        gui.updateOnMove();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
                if (time == maxTime) {
                    try {
                        gui.gameOver();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * GETTERS & SETTERS
     **/

    public static int getCurrentLevel() {
        return currentLevel;
    }

    public static void setCurrentLevel(int currentLevel) {
        Main.currentLevel = currentLevel;
    }

    public static int getTime() {
        return time;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPaused(boolean paused) {
        Main.paused = paused;
    }

    public static void setFilename(String str) {
        filename = str;
    }

    public static String getFilename() {
        return filename;
    }

    public static int getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(int maxTime) {
        this.maxTime = maxTime;
    }

    public static void main(String[] args) {
        new Main().init();
    }

    // Unused methods:

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
