package application;

import maze.Board;
import renderer.GUI;

/**
 * Main class for Chip's Challenge.
 */
public class Main {

    public static final int WIDTH = 3;
    public static final int HEIGHT = 3;

    public static void main(String[] args) {

        Board board = new Board();
        GUI gui = new GUI(board);

    }

}
