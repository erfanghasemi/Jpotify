package graphic.east;

import graphic.MainFrame;
import graphic.variouspart.FriendPanel;
import graphic.variouspart.ImageIconButton;
import logic.Controller.libraryControlller.AddFriendController;
import logic.Friend;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {

    JButton addFriend;
    ArrayList<Friend> friends;

    public MainPanel(MainFrame mainFrame) {

        friends = new ArrayList<>();

        if(new File("D:\\friend.bin").exists()) {
            readFriendsFromFile(friends);
        }


        setPreferredSize(new Dimension(120 , 250));
        setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));

        setBackground(Color.white);

        addFriend = new JButton(new ImageIconButton(".\\Icons\\Profile_AddFriend-RoundedWhite-512.png" , 50 ,50));
        addFriend.setOpaque(false);
        addFriend.setContentAreaFilled(false);
        addFriend.setBorderPainted(false);

        addFriend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddFriendController(mainFrame);

            }
        });



        JPanel addfriendPanle = new JPanel(new BorderLayout());
        addfriendPanle.setBackground(Color.white);

        addfriendPanle.setPreferredSize(new Dimension(120 , 60));
        addfriendPanle.setMaximumSize(new Dimension(120 , 60));
        addfriendPanle.setMinimumSize(new Dimension(120 , 60));

        addfriendPanle.add(addFriend , BorderLayout.CENTER);

        add(addfriendPanle);

//        System.out.println(friends.get(0).getName());

        for (Friend friend: friends) {
            FriendPanel friendPanel = new FriendPanel(mainFrame , friend.getName() , "taylor swift" , "Online" , friend.getIP());
            add(friendPanel);
        }


        TitledBorder titledBorder = new TitledBorder("Friend Activity");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setTitlePosition(TitledBorder.TOP);
        titledBorder.setTitleColor(Color.BLACK);
        titledBorder.setTitleFont(new Font("Serif", Font.BOLD, 12));
        setBorder(titledBorder);

        mainFrame.add(this , BorderLayout.EAST);
        setVisible(true);

    }



    public  void  readFriendsFromFile( ArrayList<Friend> friends) {

        try {
            FileInputStream fileIn = new FileInputStream("D:\\friend.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (true) {
                    Friend friend = (Friend) objectIn.readObject();
                    friends.add(friend);
                }
            } catch (EOFException e) {
                return;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return ;
    }



}
