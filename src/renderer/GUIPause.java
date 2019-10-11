package renderer;

import application.Main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * GUI pause for Chip's Challenge.
 *
 * @author - Ben Robertson, Eliza England, Ethan King, Jacqueline Dong, Jay Patel, Mason Yi
 */
public class GUIPause implements KeyListener {

    private JFrame mainFrame;

    public GUIPause() {
        mainFrame = new JFrame();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel text1 = new JLabel("Paused game.");
        JLabel text2 = new JLabel("Press esc to resume");

        panel1.add(text1);
        panel2.add(text2);

        mainFrame.add(panel1, "North");
        mainFrame.add(panel2, "South");

        mainFrame.setTitle("Paused");
        mainFrame.addKeyListener(this);
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
//        mainFrame.setUndecorated(true);
        mainFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        Main.setPaused(true);
    }

    /**
     * Implements pause if esc pressed.
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE) {
            Main.setPaused(false);
            mainFrame.dispose();
        }

    }

    ////////////////// Unused methods //////////////////

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
