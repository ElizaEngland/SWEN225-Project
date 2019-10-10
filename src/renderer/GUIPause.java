package renderer;

import application.Main;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUIPause implements KeyListener {

    private JFrame mainFrame;

    public GUIPause() {
        mainFrame = new JFrame();
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
