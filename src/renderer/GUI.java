package renderer;

import application.Main;
import maze.Board;
import maze.TileBlank;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

/**
 * GUI class for Chip's Challenge.
 */
public class GUI implements WindowListener {

    private Board board;
    private static JMenuBar menuBar;
    private static JMenu file;
    private static JMenuItem loadGame, saveGame;

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel[][] tileGrid = new JLabel[Main.COLS][Main.ROWS];
    private JPanel boardPanel;
    private JPanel sidePanel;
    private JPanel p1, p2, p3, p4;
    private int time = 1000;

    //Creates JLabels
    JLabel levelCountTitle, timeLeftTitle, mavsLeftTitle, inventoryTile, mavsLeft, timeLeft, levelCount;
    JLabel[][] inventoryGrid = new JLabel[4][2];


    public GUI(Board board, KeyListener keyListener) {

        mainFrame = new JFrame();
        mainFrame.setTitle("Chap's Challenge");
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
        p1.setLayout(new GridLayout(2, 1));
        p2.setLayout(new GridLayout(2, 1));
        p3.setLayout(new GridLayout(2, 1));
        p4.setLayout(new GridLayout(2, 1));

        JPanel side1 = new JPanel();
        JPanel side2 = new JPanel();

        p1.setBackground(Color.GRAY);
        p2.setBackground(Color.GRAY);
        p3.setBackground(Color.GRAY);
        p4.setBackground(Color.GRAY);
        mainPanel.setBackground(Color.GRAY);
        sidePanel.setBorder(blackline);
        mainPanel.setBorder(blackline);

        //Creates JLabels
        levelCountTitle = new JLabel();
        timeLeftTitle = new JLabel();
        mavsLeftTitle = new JLabel();
        inventoryTile = new JLabel();
        timeLeft = new JLabel();
        levelCount = new JLabel();
        mavsLeft = new JLabel();
        inventoryGrid = new JLabel[4][2];

        boardPanel.setLayout(new GridLayout(Main.ROWS, Main.COLS, 0, 0));
        sidePanel.setLayout(new GridLayout(2, 0));
        side1.setLayout(new GridLayout(3, 0));
        side2.setLayout(new GridLayout(2, 0));

        // create board
        for (int row = 0; row < Main.ROWS; row++) {
            for (int col = 0; col < Main.COLS; col++) {
                tileGrid[col][row] = new JLabel(board.getTile(col, row).getIcon());
                boardPanel.add(tileGrid[col][row]);
            }
        }

        levelCountTitle.setText("LEVEL");
        timeLeftTitle.setText("TIME");
        mavsLeftTitle.setText("TREASURE REMAINING:");
        inventoryTile.setText("INVENTORY");

        levelCountTitle.setForeground(Color.green);
        timeLeftTitle.setForeground(Color.green);
        mavsLeftTitle.setForeground(Color.green);
        inventoryTile.setForeground(Color.green);
        mavsLeft.setForeground(Color.green);

        levelCountTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        timeLeftTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mavsLeftTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryTile.setAlignmentX(Component.CENTER_ALIGNMENT);
        levelCountTitle.setHorizontalAlignment(SwingConstants.CENTER);
        timeLeftTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mavsLeftTitle.setHorizontalAlignment(SwingConstants.CENTER);
        inventoryTile.setHorizontalAlignment(SwingConstants.CENTER);
        mavsLeft.setHorizontalAlignment(SwingConstants.CENTER);


        Font largeFont = new Font("Courier", Font.BOLD, 50);
        mavsLeft.setFont(largeFont);

        p1.add(levelCountTitle);
        p1.add(levelCount);
        p2.add(timeLeftTitle);
        p2.add(timeLeft);
        p3.add(mavsLeftTitle);
        p3.add(mavsLeft);
        p4.add(inventoryTile);
        //TODO add a grid in the south of p4


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
    public void windowClosing(WindowEvent e) {
        // Ask the user to confirm they wanted to do this
        int r = JOptionPane.showConfirmDialog(mainFrame,
                new JLabel("Exit Game?"), "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (r == JOptionPane.YES_OPTION) System.exit(0);
    }

    /**
     * Update the icons on the board (called each time a move is made).
     */
    public void update() {

        for (int row = 0; row < Main.ROWS; row++) {
            for (int col = 0; col < Main.COLS; col++) {
//                tileGrid[col][row].setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
                tileGrid[col][row].setIcon(board.getTile(col, row).getIcon());
                mavsLeft.setText("" + (Main.MAX_TREASURE - Main.getPlayer().getMavsCollected()));

            }
        }

        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 4; col++) {
//                inventoryGrid[row][col].setBackground(Color.BLUE);
            }
        }

    }

    // Unused methods:

    @Override
    public void windowOpened(WindowEvent e) {

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