package renderer;

import javax.swing.*;
import java.awt.*;

/**
 * GUI class for Chip's Challenge.
 */
public class GUI extends JFrame {

    public GUI() {

        super("Chap’s Challenge");

        setPreferredSize(new Dimension(500, 500));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}