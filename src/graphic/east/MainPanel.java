package graphic.east;

import graphic.MainFrame;
import graphic.variouspart.FriendPanel;
import graphic.variouspart.ImageIconButton;
import logic.Controller.libraryControlller.AddFriendController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {

    JButton addFriend;
    FriendPanel friendPanel;
    ArrayList<String> IPs = new ArrayList<>();

    public MainPanel(MainFrame mainFrame) {

        if(new File("D:\\friend.bin").exists()) {
            readIPFromFile(IPs);
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



        for (String IP: IPs) {
            FriendPanel friendPanel = new FriendPanel(mainFrame , "Ghiyasi" , "moein" , "Online" , IP);
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

    public void readIPFromFile(ArrayList<String> IPs) {

        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\friend.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            try {


                while (true) {

                    String IP = (String) objectInputStream.readObject();
                    IPs.add(IP);
                }


            } catch (EOFException e) {
                return;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
