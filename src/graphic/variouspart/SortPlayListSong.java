package graphic.variouspart;

import javax.swing.*;
import java.awt.*;

public class SortPlayListSong extends JPanel {


    JTextField firstSong , secondsSong;
    JButton submitChange;
    JLabel textLabel;

    public SortPlayListSong() {

        setBackground(Color.white);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        textLabel = new JLabel("          To  ");
        submitChange = new JButton("Apply");
        firstSong  = new JTextField();
        secondsSong  = new JTextField();

        submitChange.setMinimumSize(new Dimension(30 , 30));

        c.gridx = 0;
        c.gridy = 1;
        c.ipady = 15;
        c.ipadx = 60;
        add(firstSong , c);

        c.gridx = 1;
        c.gridy = 1;
        c.ipady = 15;
        c.ipadx = 30;
        add(textLabel , c);

        c.gridx = 2;
        c.gridy = 1;
        c.ipady = 15;
        c.ipadx = 60;
        add(secondsSong , c);


        c.gridx = 1;
        c.gridy = 2;
        c.ipady = 15;
        c.ipadx = 15;
        add(submitChange , c);
        setVisible(true);
    }
}
