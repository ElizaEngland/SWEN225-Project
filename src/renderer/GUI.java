package renderer;

import application.Main;
import maze.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * GUI class for Chip's Challenge.
 */
public class GUI extends JFrame implements WindowListener {

    private Board board;
    private static JMenuBar menuBar;
    private static JMenu file;
    private static JMenuItem loadGame, saveGame;

    public GUI(Board board, KeyListener keyListener) {

        super("Chap’s Challenge");
        addKeyListener(keyListener);

        this.board = board;
        makeMenuBar();
        createFrame();

        addWindowListener(this);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    private void makeMenuBar() {
        menuBar = new JMenuBar();

        file = new JMenu("File");

        loadGame = new JMenuItem("Load Game");
        saveGame = new JMenuItem("Save Game");

        file.add(loadGame);
        file.add(saveGame);

        menuBar.add(file);

        setJMenuBar(menuBar);
    }

    private void createFrame() {
        JPanel mainPanel = new JPanel();
        JPanel boardPanel = new JPanel();
        JLabel[][] tileGrid = new JLabel[Main.WIDTH][Main.HEIGHT];

        boardPanel.setLayout(new GridLayout(Main.HEIGHT, Main.WIDTH, 0, 0));

        for (int row = 0; row < Main.HEIGHT; row++) {
            for (int col = 0; col < Main.WIDTH; col++) {

                tileGrid[col][row] = new JLabel(new ImageIcon(board.getBoard()[col][row].getIcon().getImage().getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH)));
                boardPanel.add(tileGrid[col][row]);

            }
        }

        mainPanel.add(boardPanel);

        add(mainPanel, "Center");

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // Ask the user to confirm they wanted to do this
        int r = JOptionPane.showConfirmDialog(this,
                new JLabel("Exit Game?"), "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (r == JOptionPane.YES_OPTION) System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}