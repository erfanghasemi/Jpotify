package graphic.variouspart.singleplaylist;

import graphic.MainFrame;
import graphic.center.MainPanel;

import graphic.variouspart.ImageIconButton;
import graphic.variouspart.additem.AddSongPanel;
import graphic.variouspart.singlesong.SingleSongPanel;
import logic.Controller.libraryControlller.*;

import logic.PlayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static logic.Controller.libraryControlller.SubmitNewPlayListController.refreshPlayListTitleBar;


public class OptionOfPlayListPanel extends JPanel {


    JButton more , delete , rename , addSong;

    public OptionOfPlayListPanel(PlayList playList) {

        setLayout(new GridLayout(2 , 2 , 5 , 5));
        setBackground(Color.white);

        more = new JButton(new ImageIconButton(".\\Icons\\img_55392.png" , 30 , 30));
        more.setOpaque(false);
        more.setContentAreaFilled(false);
        more.setBorderPainted(false);



        delete = new JButton(new ImageIconButton(".\\Icons\\button.png" ,30,30  ));
        delete.setOpaque(false);
        delete.setContentAreaFilled(false);
        delete.setBorderPainted(false);


        rename = new JButton(new ImageIconButton(".\\Icons\\edit-button-512.png" , 30 , 30 ));
        rename.setOpaque(false);
        rename.setContentAreaFilled(false);
        rename.setBorderPainted(false);


        addSong = new JButton(new ImageIconButton(".\\Icons\\minicons-12-512.png" , 30 , 30 ));
        addSong.setOpaque(false);
        addSong.setContentAreaFilled(false);
        addSong.setBorderPainted(false);


        more.setPreferredSize(new Dimension(70 , 30));
        delete.setPreferredSize(new Dimension(70 , 30));
        rename.setPreferredSize(new Dimension(80 , 30));
        addSong.setPreferredSize(new Dimension(100 , 30));

        add(more);
        more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new SongsShowController( myFrame , mainPanel , playList);
            }
        });


        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new DeletePlayListController( playList , mainPanel, myFrame);
                refreshPlayListTitleBar("D:\\kia.bin" , myFrame.getWest().getPlaylistPanel().getPlayLists());
            }
        });


        add(rename);
        rename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                new RenamePlayListController(playList , myFrame);
            }
        });


        add(addSong);
        addSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new AddSongPlayListController( mainPanel , playList  ,myFrame);

            }
        });


        setVisible(true);
    }


}
