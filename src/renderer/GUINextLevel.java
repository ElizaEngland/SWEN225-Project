package renderer;

import javax.swing.*;
import java.awt.*;


public class GUINextLevel {
    private JFrame mainFrame;
    private JPanel panel;


    public GUINextLevel() {
        mainFrame = new JFrame();
        panel = new JPanel();
        JPanel panel1 = new JPanel();

        panel.setLayout(new FlowLayout());
        panel1.setLayout(new FlowLayout());
        JLabel text = new JLabel("Completed Level!");
        JButton nextLevel = new JButton("Next Level");
        JButton exit = new JButton("Exit");

        panel.add(text);
        panel1.add(nextLevel);
        panel1.add(exit);
        mainFrame.add(panel,"North");
        mainFrame.add(panel1,"South");
        mainFrame.setTitle("Level Complete!");
        mainFrame.pack();
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }

}
