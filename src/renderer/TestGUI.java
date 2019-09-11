/*
 * Created by JFormDesigner on Wed Sep 11 20:18:09 NZST 2019
 */

package renderer;

import application.Main;
import maze.Board;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author unknown
 */
public class TestGUI extends JFrame {

    public TestGUI(Board board) {

        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        menuBar = new JMenuBar();
        menu1 = new JMenu();
        quitMenuItem = new JMenuItem();
        boardPanel = new JPanel();
        board = new JPanel();
        panel7 = new JPanel();
        panel8 = new JPanel();
        panel9 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        panel10 = new JPanel();
        label5 = new JLabel();
        label6 = new JLabel();
        panel11 = new JPanel();
        label7 = new JLabel();
        label8 = new JLabel();
        panel12 = new JPanel();

        //======== this ========
        Container contentPane = getContentPane();

        //======== menuBar ========
        {

            //======== menu1 ========
            {
                menu1.setText("File");

                //---- quitMenuItem ----
                quitMenuItem.setText("Quit");
                menu1.add(quitMenuItem);
            }
            menuBar.add(menu1);
        }
        setJMenuBar(menuBar);

        //======== boardPanel ========
        {
            boardPanel.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border. EmptyBorder( 0
            , 0, 0, 0) , "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax. swing. border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM
            , new java .awt .Font ("D\u0069alog" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red) ,
            boardPanel. getBorder( )) ); boardPanel. addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
            ) {if ("\u0062order" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} );
            boardPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            //======== board ========
            {
                board.setLayout(new GridLayout(9, 9));
            }
            boardPanel.add(board);
        }

        //======== panel7 ========
        {
            panel7.setBackground(new Color(255, 51, 51));
            panel7.setLayout(new FlowLayout());

            //======== panel8 ========
            {
                panel8.setBackground(new Color(255, 51, 51));
                panel8.setForeground(new Color(255, 51, 51));
                panel8.setLayout(new GridBagLayout());
                ((GridBagLayout)panel8.getLayout()).columnWidths = new int[] {0, 0};
                ((GridBagLayout)panel8.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
                ((GridBagLayout)panel8.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                ((GridBagLayout)panel8.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0E-4};

                //======== panel9 ========
                {
                    panel9.setLayout(new GridLayout(2, 1));

                    //---- label3 ----
                    label3.setText("LEVEL:");
                    label3.setHorizontalAlignment(SwingConstants.CENTER);
                    label3.setFont(new Font("Roboto", Font.PLAIN, 17));
                    panel9.add(label3);

                    //---- label4 ----
                    label4.setText("0");
                    label4.setHorizontalAlignment(SwingConstants.CENTER);
                    label4.setFont(new Font("Roboto", Font.PLAIN, 17));
                    panel9.add(label4);
                }
                panel8.add(panel9, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 40, 0), 0, 0));

                //======== panel10 ========
                {
                    panel10.setLayout(new GridLayout(2, 1));

                    //---- label5 ----
                    label5.setText("TIME:");
                    label5.setHorizontalAlignment(SwingConstants.CENTER);
                    label5.setFont(new Font("Roboto", Font.PLAIN, 17));
                    panel10.add(label5);

                    //---- label6 ----
                    label6.setText("0");
                    label6.setHorizontalAlignment(SwingConstants.CENTER);
                    label6.setFont(new Font("Roboto", Font.PLAIN, 17));
                    panel10.add(label6);
                }
                panel8.add(panel10, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 40, 0), 0, 0));

                //======== panel11 ========
                {
                    panel11.setLayout(new GridLayout(2, 1));

                    //---- label7 ----
                    label7.setText("CHIPS LEFT:");
                    label7.setHorizontalAlignment(SwingConstants.CENTER);
                    label7.setFont(new Font("Roboto", Font.PLAIN, 17));
                    panel11.add(label7);

                    //---- label8 ----
                    label8.setText("0");
                    label8.setHorizontalAlignment(SwingConstants.CENTER);
                    label8.setFont(new Font("Roboto", Font.PLAIN, 17));
                    panel11.add(label8);
                }
                panel8.add(panel11, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 40, 0), 0, 0));

                //======== panel12 ========
                {
                    panel12.setLayout(new GridLayout(2, 4));
                }
                panel8.add(panel12, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panel7.add(panel8);
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(boardPanel, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(panel7, GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addGap(15, 15, 15))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(boardPanel, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
                        .addComponent(panel7, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE))
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenuItem quitMenuItem;
    private JPanel boardPanel;
    private JPanel board;
    private JPanel panel7;
    private JPanel panel8;
    private JPanel panel9;
    private JLabel label3;
    private JLabel label4;
    private JPanel panel10;
    private JLabel label5;
    private JLabel label6;
    private JPanel panel11;
    private JLabel label7;
    private JLabel label8;
    private JPanel panel12;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
