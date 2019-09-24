package renderer;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUINextLevel implements ActionListener {
    private JFrame mainFrame;
    private JPanel panel;
    private JButton nextLevel;
    private JButton exit;

    public GUINextLevel() {
        mainFrame = new JFrame();
        panel = new JPanel();
        JPanel panel1 = new JPanel();

        panel.setLayout(new FlowLayout());
        panel1.setLayout(new FlowLayout());
        JLabel text = new JLabel("Completed Level!");
        nextLevel = new JButton("Next Level");
        exit = new JButton("Exit");

        nextLevel.addActionListener(this);
        exit.addActionListener(this);
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


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == nextLevel ){
            System.out.println("Next level");
        }
        else if(e.getSource()==exit){
            System.exit(0);
        }
    }
}
