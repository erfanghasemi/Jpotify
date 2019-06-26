package graphic.variouspart;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class FriendPanel extends  JPanel{

    JLabel nameOfFriend , state , titleOfMusic;
    JButton openShare;

    public FriendPanel(String name , String songtitle , String stateOfFriend) {


        setBackground(Color.white);
        setLayout(new GridLayout(4 , 1 , 5 , 5 ));
        setPreferredSize(new Dimension(120  , 120));
        setMinimumSize(new Dimension(120  , 120));
        setMaximumSize(new Dimension(120  , 120));

        nameOfFriend  = new JLabel(name);
        state = new JLabel(songtitle);
        titleOfMusic = new JLabel(stateOfFriend);

        state.setHorizontalAlignment(JLabel.CENTER);
        nameOfFriend.setHorizontalAlignment(JLabel.CENTER);
        titleOfMusic.setHorizontalAlignment(JLabel.CENTER);

        openShare = new JButton("Open");
        openShare.setPreferredSize(new Dimension(120  , 25));
        openShare.setMinimumSize(new Dimension(120  , 25));
        openShare.setMaximumSize(new Dimension(120  , 25));


        setBorder(BorderFactory.createLineBorder(Color.black, 1));



        add(nameOfFriend);
        add(titleOfMusic);
        add(state);
        add(openShare);

        setVisible(true);
    }
}
