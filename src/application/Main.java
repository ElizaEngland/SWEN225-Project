package application;

import maze.Board;
import renderer.GUI;
import renderer.TestGUI;

/**
 * Main class for Chip's Challenge.
 */
public class Main {

    public static final int WIDTH = 9;
    public static final int HEIGHT = 9;

    public static void main(String[] args) {

        Board board = new Board();
//        GUI gui = new GUI(board);

         new TestGUI(board);

    }
}
