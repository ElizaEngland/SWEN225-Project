package renderer;

import application.Main;
import maze.Board;
import maze.Tile;

import javax.swing.*;
import java.awt.*;

/**
 * GUI class for Chip's Challenge.
 */
public class GUI extends JFrame {

    private Board board;

    public GUI(Board board) {

        super("Chap’s Challenge");

        this.board = board;
        createFrame();

        setPreferredSize(new Dimension(500, 500));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void createFrame() {

        JPanel mainPanel = new JPanel();
        JPanel boardPanel = new JPanel();
        JLabel[][] tileGrid = new JLabel[Main.WIDTH][Main.HEIGHT];

        boardPanel.setLayout(new GridLayout(Main.HEIGHT, Main.WIDTH, 0, 0));

        for (int row = 0; row < Main.HEIGHT; row++) {
            for (int col = 0; col < Main.WIDTH; col++) {
                tileGrid[col][row] = new JLabel(board.getBoard()[col][row].getIcon());
                boardPanel.add(tileGrid[col][row]);
            }
        }

        mainPanel.add(boardPanel);

        add(mainPanel, "Center");

    }

}