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
    private JPanel mainPanel;
    private static JLabel[][] tileGrid = new JLabel[Main.COLS][Main.ROWS];
    private JPanel boardPanel;
    private JPanel sidePanel;
    private JPanel p1,p2,p3,p4;


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
        mainPanel = new JPanel();
        Border blackline = BorderFactory.createLineBorder(Color.black);
        mainFrame.setPreferredSize(new Dimension(725, 625));

        //create panels
        boardPanel = new JPanel();
        sidePanel = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p4 = new JPanel();

        JPanel side1 = new JPanel();
        JPanel side2 = new JPanel();

        p1.setBackground(Color.GRAY);
        p2.setBackground(Color.GRAY);
        p3.setBackground(Color.GRAY);
        p4.setBackground(Color.GRAY);
        mainPanel.setBackground(Color.GRAY);
        sidePanel.setBorder(blackline);
        mainPanel.setBorder(blackline);

        JLabel levelCount = new JLabel();
        JLabel timeLeft = new JLabel();
        JLabel mavsLeft = new JLabel();
        JLabel inventory = new JLabel();

        boardPanel.setLayout(new GridLayout(Main.ROWS, Main.COLS, 0, 0));
        sidePanel.setLayout(new GridLayout(2, 0));
        side1.setLayout(new GridLayout(3, 0));
        side2.setLayout(new GridLayout(2, 0));

        // create board
        for (int row = 0; row < Main.ROWS; row++) {
            for (int col = 0; col < Main.COLS; col++) {
                tileGrid[col][row] = new JLabel(board.getBoard()[col][row].getIcon());
                boardPanel.add(tileGrid[col][row]);
            }
        }

        levelCount.setText("LEVEL");
        timeLeft.setText("TIME");
        mavsLeft.setText("TREASURE");
        inventory.setText("INVENTORY");

        levelCount.setForeground(Color.green);
        timeLeft.setForeground(Color.green);
        mavsLeft.setForeground(Color.green);
        inventory.setForeground(Color.green);

        levelCount.setAlignmentX(Component.CENTER_ALIGNMENT);
        timeLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
        mavsLeft.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventory.setAlignmentX(Component.CENTER_ALIGNMENT);


        p1.add(levelCount);
        p2.add(timeLeft);
        p3.add(mavsLeft);
        p4.add(inventory);




        side1.add(p1, "North");
        side1.add(p2, "Center");
        side1.add(p3, "North");
        side2.add(p4, "South");

        sidePanel.add(side1);
        sidePanel.add(side2);

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