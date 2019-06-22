package graphic.west;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Controller.libraryControlller.AddPlayListShowController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaylistPanel extends JPanel {

    TitledBorder titledBorder;
    JButton newPlayList;
    JList playLists;
    String[] playListNames = {"Share" , "Favourite" , "Pop" , "Rap" , "Jazz" , "HipHop" ,"HipHop","HipHop","HipHop","HipHop","HipHop","HipHop","HipHop"};

    public PlaylistPanel() {

        setBackground(Color.white);
        setLayout(new BorderLayout());

        newPlayList = new JButton(" New Playlist");
        playLists = new JList(playListNames);
        JScrollPane scrollPane = new JScrollPane(playLists);

        add(newPlayList, BorderLayout.NORTH);
        add(scrollPane , BorderLayout.CENTER);


        newPlayList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(newPlayList);
                MainPanel mainPanel = myFrame.getCenter();
                new AddPlayListShowController(mainPanel);
            }
        });


        titledBorder = new TitledBorder("Playlist");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setTitlePosition(TitledBorder.TOP);
        titledBorder.setTitleColor(Color.BLACK);
        titledBorder.setTitleFont(new Font("Serif", Font.BOLD, 12));
        setBorder(titledBorder);

        setVisible(true);
    }
}
