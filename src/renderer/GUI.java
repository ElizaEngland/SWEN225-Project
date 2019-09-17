package renderer;

import application.Item;
import application.Main;
import maze.Board;

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

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JLabel[][] tileGrid = new JLabel[Main.COLS][Main.ROWS];
    private JPanel boardPanel;
    private JPanel sidePanel;
    private JPanel p1, p2, p3, p4;

    //Creates JLabels
    JLabel levelCountTitle, timeLeftTitle, mavsLeftTitle, inventoryTile, mavsLeft, timeLeft, levelCount;
    JPanel inventoryPanel;
    JLabel[][] inventoryGrid;


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
        levelCount = new JLabel();

        timeLeftTitle = new JLabel();
        timeLeft = new JLabel();

        mavsLeftTitle = new JLabel();
        mavsLeft = new JLabel();

        inventoryTile = new JLabel();
        inventoryPanel = new JPanel();
        inventoryGrid = new JLabel[4][2];

        inventoryPanel.setLayout(new GridLayout(2, 4, 0, 0));
        inventoryPanel.setBackground(Color.GRAY);

        boardPanel.setLayout(new GridLayout(Main.ROWS, Main.COLS, 0, 0));
        sidePanel.setLayout(new GridLayout(2, 0));
        side1.setLayout(new GridLayout(3, 0));
        side2.setLayout(new GridLayout(2, 0));

        // create board
        for (int row = 0; row < Main.ROWS; row++) {
            for (int col = 0; col < Main.COLS; col++) {
                tileGrid[col][row] = new JLabel();
                boardPanel.add(tileGrid[col][row]);
            }
        }

        // create inventory
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < 4; col++) {
                inventoryGrid[col][row] = new JLabel();
                inventoryPanel.add(inventoryGrid[col][row]);
            }
        }

        levelCountTitle.setText("LEVEL");
        timeLeftTitle.setText("TIME");
        mavsLeftTitle.setText("TREASURE REMAINING");
        inventoryTile.setText("INVENTORY");

        levelCountTitle.setForeground(Color.green);
        timeLeftTitle.setForeground(Color.green);
        mavsLeftTitle.setForeground(Color.green);
        inventoryTile.setForeground(Color.green);
        mavsLeft.setForeground(Color.green);
        timeLeft.setForeground(Color.green);
        levelCount.setForeground(Color.green);

        levelCountTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        timeLeftTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        mavsLeftTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        inventoryTile.setAlignmentX(Component.CENTER_ALIGNMENT);
        levelCountTitle.setHorizontalAlignment(SwingConstants.CENTER);
        timeLeftTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mavsLeftTitle.setHorizontalAlignment(SwingConstants.CENTER);
        inventoryTile.setHorizontalAlignment(SwingConstants.CENTER);
        mavsLeft.setHorizontalAlignment(SwingConstants.CENTER);
        timeLeft.setHorizontalAlignment(SwingConstants.CENTER);
        levelCount.setHorizontalAlignment(SwingConstants.CENTER);

        Font largeFont = new Font("Courier", Font.BOLD, 50);
        mavsLeft.setFont(largeFont);
        timeLeft.setFont(largeFont);
        levelCount.setFont(largeFont);

        p1.add(levelCountTitle);
        p1.add(levelCount);
        p2.add(timeLeftTitle);
        p2.add(timeLeft);
        p3.add(mavsLeftTitle);
        p3.add(mavsLeft);
        p4.add(inventoryTile);
        p4.add(inventoryPanel);

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
//                                tileGrid[col][row].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                tileGrid[col][row].setIcon(board.getTile(col, row).getIcon());

                mavsLeft.setText(String.valueOf(Main.MAX_TREASURE - Main.getPlayer().getMavsCollected()));
                levelCount.setText(board.getLevelName());
                timeLeft.setText("100"); // TODO: 17/09/2019 should be the actual time remaining not just 100

            }
        }

        int row = 0;
        int col = 0;
        for (Item item : Main.getPlayer().getInventory()) {
            inventoryGrid[col][row].setBorder(BorderFactory.createLineBorder(Color.BLACK)); // TODO: 17/09/2019 Just need to make this an icon for the item
            if (col == 3) {
                row++;
                col = 0;
            } else {
                col++;
            }
        }

        if (Main.getPlayer().isInfoRequested()) {
            JOptionPane.showMessageDialog(mainFrame, "Test");
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