package graphic.east;

import graphic.MainFrame;
import graphic.variouspart.FriendPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainPanel extends JPanel {

    JButton addFriend;
    FriendPanel friendPanel;

    public MainPanel(MainFrame mainFrame) {

        setPreferredSize(new Dimension(120 , 250));
        setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));

        setBackground(Color.white);

        addFriend = new JButton("Add Friend");
        addFriend.setPreferredSize(new Dimension(120 , 25));
        addFriend.setMaximumSize(new Dimension(120 , 25));
        addFriend.setMinimumSize(new Dimension(120 , 25));




        friendPanel = new FriendPanel("Erfan" , "Red" , "Online");
        add(friendPanel);

//        add(addFriend);

        FriendPanel a = new FriendPanel("Reza" , "Jodaee" ,"44 m");
        add(a);

        FriendPanel f = new FriendPanel("ali" , "Stay Stay Stay" , "Online");
        add(f);


        TitledBorder titledBorder = new TitledBorder("Friend Activity");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setTitlePosition(TitledBorder.TOP);
        titledBorder.setTitleColor(Color.BLACK);
        titledBorder.setTitleFont(new Font("Serif", Font.BOLD, 12));
        setBorder(titledBorder);

        mainFrame.add(this , BorderLayout.EAST);
        setVisible(true);

    }
}
