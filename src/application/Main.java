package application;

import maze.Board;
import renderer.GUI;

/**
 * Main class for Chip's Challenge.
 */
public class Main {

    public static void main(String[] args) {

        Board board = new Board();
        GUI gui = new GUI(board);

    }

}
