package graphic.west;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Controller.libraryControlller.AddPlayListShowController;
import logic.Controller.libraryControlller.PlayListController;
import logic.Controller.libraryControlller.SubmitNewPlayListController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlaylistPanel extends JPanel {

    TitledBorder titledBorder;
    JButton newPlayList , addedPlayList;
    JList playLists;

    public PlaylistPanel() {

        setBackground(Color.white);
        setLayout(new BorderLayout());

        newPlayList = new JButton(" New Playlist");
        addedPlayList = new JButton("Added Playlist");

        playLists = new JList();

        new SubmitNewPlayListController(null , "Favourite");
        new SubmitNewPlayListController(null , "Share").refreshPlayListTitleBar("D:\\kia.bin" , playLists);

        JScrollPane scrollPane = new JScrollPane(playLists);

        add(addedPlayList, BorderLayout.NORTH);
        add(scrollPane , BorderLayout.CENTER);
        add(newPlayList  ,BorderLayout.SOUTH);

        newPlayList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(newPlayList);
                MainPanel mainPanel = myFrame.getCenter();
                new AddPlayListShowController(mainPanel);
            }
        });

        addedPlayList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(newPlayList);
                MainPanel mainPanel = myFrame.getCenter();
                new PlayListController(mainPanel);
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

    public JList getPlayLists() {
        return playLists;
    }
}
