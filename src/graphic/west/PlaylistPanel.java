package graphic.west;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Controller.libraryControlller.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static logic.Controller.libraryControlller.SubmitNewPlayListController.refreshPlayListTitleBar;

public class PlaylistPanel extends JPanel {

    TitledBorder titledBorder;
    JButton newPlayList , addedPlayList;
    static  JList playLists;

    public PlaylistPanel() {

        setBackground(Color.white);
        setLayout(new BorderLayout());

        newPlayList = new JButton(" New Playlist");
        addedPlayList = new JButton("Added Playlist");

        playLists = new JList();


        new SubmitNewPlayListController( "Favourite");
        new SubmitNewPlayListController( "Share");
        refreshPlayListTitleBar("D:\\kia.bin" , playLists);

        playLists.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(playLists.getValueIsAdjusting()) {
                    MainFrame myFrame = (MainFrame) SwingUtilities.getWindowAncestor(newPlayList);
                    MainPanel mainPanel = myFrame.getCenter();
                    new JlistListener(myFrame, mainPanel, playLists.getSelectedValue().toString());
                }
            }
        });

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
                new PlayListController(myFrame , mainPanel);
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
