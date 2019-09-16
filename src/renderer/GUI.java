package renderer;

import application.Main;
import maze.Board;
import maze.Tile;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * GUI class for Chip's Challenge.
 */
public class GUI implements WindowListener {

    private Board board;
    private static JMenuBar menuBar;
    private static JMenu file;
    private static JMenuItem loadGame, saveGame;
    private static JFrame mainFrame;
    private static JLabel[][] tileGrid = new JLabel[Main.COLS][Main.ROWS];

    public GUI(Board board, KeyListener keyListener) {

        mainFrame = new JFrame();
        //super("Chap’s Challenge");
        mainFrame.addKeyListener(keyListener);

        this.board = board;
        makeMenuBar();
        createFrame();

        mainFrame.addWindowListener(this);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);

    }

    private void makeMenuBar() {
        menuBar = new JMenuBar();

        file = new JMenu("File");

        loadGame = new JMenuItem("Load Game");
        saveGame = new JMenuItem("Save Game");

        file.add(loadGame);
        file.add(saveGame);

        menuBar.add(file);

        mainFrame.setJMenuBar(menuBar);
    }

    private void createFrame() {
        System.out.println(mainFrame.WIDTH + "," + mainFrame.HEIGHT);
        JPanel mainPanel = new JPanel();
        mainFrame.setPreferredSize(new Dimension(725, 625));
        JPanel boardPanel = new JPanel();
        JPanel sidePanel = new JPanel();
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();

        Border blackline = BorderFactory.createLineBorder(Color.black);
        p1.setBackground(Color.GRAY);
        p2.setBackground(Color.GRAY);
        mainPanel.setBackground(Color.GRAY);
        sidePanel.setBorder(blackline);
        mainPanel.setBorder(blackline);

        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));


        JLabel levelcount = new JLabel();
        JLabel timeLeft = new JLabel();
        JLabel mavsLeft = new JLabel();
        JLabel inventory = new JLabel();

        boardPanel.setLayout(new GridLayout(Main.ROWS, Main.COLS, 0, 0));

        for (int row = 0; row < Main.ROWS; row++) {
            for (int col = 0; col < Main.COLS; col++) {

                tileGrid[col][row] = new JLabel(board.getBoard()[col][row].getIcon());
                boardPanel.add(tileGrid[col][row]);

            }
        }


        levelcount.setText("LEVEL");
        timeLeft.setText("TIME");
        mavsLeft.setText("TREASURE");
        inventory.setText("INVENTORY");


        levelcount.setAlignmentX(Component.CENTER_ALIGNMENT);
        timeLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
        mavsLeft.setAlignmentX(Component.CENTER_ALIGNMENT);

        levelcount.setForeground(Color.green);
        timeLeft.setForeground(Color.green);
        mavsLeft.setForeground(Color.green);
        inventory.setForeground(Color.green);
        sidePanel.setLayout(new GridLayout(3, 0));
        p1.add(levelcount, "North");
        p1.add(timeLeft, "South");
        p2.add(mavsLeft, "North");
        p2.add(inventory, "South");

        sidePanel.add(p1, "North");
        sidePanel.add(p2, "South");
        mainPanel.add(boardPanel);
        mainPanel.add(sidePanel);

        mainFrame.add(mainPanel, "Center");
        mainFrame.add(sidePanel, "West");

    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        // Ask the user to confirm they wanted to do this
        int r = JOptionPane.showConfirmDialog(mainFrame,
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

    public void update() {

        for (int row = 0; row < Main.ROWS; row++) {
            for (int col = 0; col < Main.COLS; col++) {
                tileGrid[col][row].setIcon(board.getBoard()[col][row].getIcon());
            }
        }

    }
}