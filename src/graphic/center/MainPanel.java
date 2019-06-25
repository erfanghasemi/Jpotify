package graphic.center;

import graphic.variouspart.singlesong.SingleSongPanel;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainPanel extends JPanel {
/*
    JPanel north , center , south;
    JLabel imageWelcome , labelText;
    JTextField textField;
    JButton submit;*/

    public MainPanel(JFrame mainFrame) {
/*

        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());
        GridBagConstraints c  =new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;



        north = new JPanel();
        center = new JPanel();
        south = new JPanel();

        north.setBackground(Color.red);
        center.setBackground(Color.yellow);
        south.setBackground(Color.green);


//        textField = new JTextField();
        // labelText = new JLabel("User Name:  ");

        c.ipady = 300;
        c.ipadx = 650;
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.PAGE_START;
        add(north , c);


        c.ipady = 50;
        c.ipadx = 150;
        c.gridx = 1;
        c.gridy = 2;

        add(center , c);


        c.ipady = 50;
        c.ipadx = 150;
        c.gridx = 2;
        c.gridy = 1;
        c.anchor = GridBagConstraints.LINE_START;
        add(south , c);



*/


        //add(labelText);


        mainFrame.add(this , BorderLayout.CENTER);
        setVisible(true);

    }
}
