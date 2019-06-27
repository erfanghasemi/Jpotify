package graphic.variouspart;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Controller.libraryControlller.SortPlayListSongController;
import logic.PlayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SortPlayListSong extends JPanel {


    JTextField firstSong , secondsSong;
    JButton submitChange;
    JLabel textLabel;

    public SortPlayListSong(PlayList playList) {

        setBackground(Color.white);
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        textLabel = new JLabel("          To  ");

        submitChange = new JButton(new ImageIconButton(".\\Icons\\19879.png" , 40 , 40 ));
        submitChange.setOpaque(false);
        submitChange.setContentAreaFilled(false);
        submitChange.setBorderPainted(false);

        firstSong  = new JTextField();
        secondsSong  = new JTextField();

        submitChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(submitChange);
                MainPanel mainPanel = myFrame.getCenter();
                new SortPlayListSongController( myFrame ,  mainPanel , playList ,firstSong.getText()  ,secondsSong.getText());
            }
        });

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
