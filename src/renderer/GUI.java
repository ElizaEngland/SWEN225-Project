package renderer;

import application.Item;
import application.Main;
import maze.Board;
import persistence.Read;
import persistence.Write;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

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

        updateBoard();
        updatePanel();

    }

    /**
     * Creates the menubar up the top of the JFrame
     */
    private void makeMenuBar() {
        menuBar = new JMenuBar();

        file = new JMenu("File");

        loadGame = new JMenuItem("Load Game");
        saveGame = new JMenuItem("Save Game");

        loadGame.addActionListener(ev -> loadPopup());

        saveGame.addActionListener(ev -> savePopup());

        file.add(loadGame);
        file.add(saveGame);

        menuBar.add(file);
        mainFrame.setJMenuBar(menuBar);
    }


    /**
     * Create the pop up for loading in a level
     */
    public void loadPopup() {
        System.out.println("LOADING GAME");
        Read r = new Read();
        JFileChooser fileChooser = new JFileChooser("../group-project/savedGame");
        fileChooser.setDialogTitle("Loading file...");
        int address = fileChooser.showOpenDialog(null);

        if (address == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            r.readFile(selectedFile.getAbsolutePath());
        }
    }

    /**
     * Create the pop up for saving a level
     */
    public void savePopup() {
        Write w = new Write();
        JFileChooser fileChooser = new JFileChooser("../group-project/savedGame");
        fileChooser.setDialogTitle("Saving file...");
        int returnValue = fileChooser.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File toSave = fileChooser.getSelectedFile();
            System.out.println(Main.getPlayer().getInventory().toString());
            w.saveJSONFile(toSave.getAbsolutePath(), timeLeft.getText(), board);
        }
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
        sidePanel.setLayout(new GridLayout(1, 1));
        side1.setLayout(new GridLayout(4, 1));
//        side2.setLayout(new GridLayout(2, 0));

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
        side1.add(p4, "South");

        sidePanel.add(side1);

        mainPanel.add(boardPanel);
        mainPanel.add(sidePanel);

        mainFrame.add(mainPanel, "Center");
        mainFrame.add(sidePanel, "West");

    }

    /**
     * Used to confirm whether a player wants to exit the game or not
     */
    @Override
    public void windowClosing(WindowEvent e) {
        int r = JOptionPane.showConfirmDialog(mainFrame,
                new JLabel("Exit Game?"), "Confirm Exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (r == JOptionPane.YES_OPTION) System.exit(0);
    }

    /**
     * Update the icons on the board (called each time a move is made).
     */
    public void updateBoard() {

        if (board == null) {
            return;
        }

        for (int row = 0; row < Main.ROWS; row++) {
            for (int col = 0; col < Main.COLS; col++) {

                tileGrid[col][row].setIcon(board.getTile(col, row).getIcon());

                mavsLeft.setText(String.valueOf(Main.MAX_TREASURE - Main.getPlayer().getTreasureCollected()));
                levelCount.setText(board.getLevelName());

            }
        }

        int row = 0;
        int col = 0;
        for (Item item : Main.getPlayer().getInventory()) {
//            inventoryGrid[col][row].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            inventoryGrid[col][row].setIcon(item.getIcon());
            if (col == 3) {
                row++;
                col = 0;
            } else {
                col++;
            }
        }

        //TODO: 17/9/19 replace the message with the actual information
        if (Main.getPlayer().isInfoRequested()) {
            JOptionPane.showMessageDialog(mainFrame, "Test", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void updatePanel() {
        timeLeft.setText(Integer.toString(Main.getMaxTime() - Main.getTime()));
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

    public void GameOver() {
        JOptionPane.showMessageDialog(mainFrame, "GAME OVER", "GAME OVER", JOptionPane.INFORMATION_MESSAGE);
    }


}