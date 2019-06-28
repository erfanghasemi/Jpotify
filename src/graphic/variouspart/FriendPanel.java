package graphic.variouspart;

import graphic.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FriendPanel extends  JPanel{

    JLabel nameOfFriend , state , titleOfMusic;
    JButton openShare;

    public FriendPanel(MainFrame mainFrame , String name , String songtitle , String stateOfFriend , String IP) {


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

        openShare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.getClient().connect(IP);
                System.out.println("salam");
                mainFrame.getClient().setRequest(IP , "SharePlayList");
                System.out.println("erfan");
                

//                new SongsShowController(mainFrame , mainFrame.getCenter() , IP , mainFrame.getClient().getClientIP().get(IP).getSharePlayList());

            }
        });


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
