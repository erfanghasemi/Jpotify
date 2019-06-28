package graphic.variouspart.singlesong;

import graphic.MainFrame;
import graphic.center.MainPanel;
import graphic.variouspart.ImageIconButton;
import logic.Album;
import logic.Controller.libraryControlller.DeleteSongController;
import logic.Controller.libraryControlller.DeleteSongPlayListController;
import logic.Controller.libraryControlller.PlaySongController;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class OptionOfSongPanel extends JPanel {

    JButton delete , play , download;

    public OptionOfSongPanel(Song song) {


        setLayout(new FlowLayout(1 , 25, 42));
        setBackground(Color.white);

        delete = new JButton(new ImageIconButton(".\\Icons\\button.png" , 30 , 30 ));
        delete.setOpaque(false);
        delete.setContentAreaFilled(false);
        delete.setBorderPainted(false);


        play = new JButton(new ImageIconButton(".\\Icons\\img_153075.png" , 30 , 30));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);

        delete.setPreferredSize(new Dimension(60 , 40));
        play.setPreferredSize(new Dimension(60 , 40));


        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new DeleteSongController( song , mainPanel , myFrame);

            }
        });


        add(play);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                try {
                    new PlaySongController(myFrame ,song);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        setVisible(true);
    }





    public OptionOfSongPanel(Song song , Album album) {

        setLayout(new FlowLayout(1 , 25, 42));
        setBackground(Color.white);

        delete = new JButton(new ImageIconButton(".\\Icons\\button.png" , 30 , 30 ));
        delete.setOpaque(false);
        delete.setContentAreaFilled(false);
        delete.setBorderPainted(false);


        play = new JButton(new ImageIconButton(".\\Icons\\img_153075.png" , 30 , 30));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);

        delete.setPreferredSize(new Dimension(60 , 40));
        play.setPreferredSize(new Dimension(60 , 40));


        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new DeleteSongController( song , album ,  mainPanel , myFrame);

            }
        });

        add(play);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                try {
                    new PlaySongController(myFrame ,song ,album);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        setVisible(true);
    }


    public OptionOfSongPanel(Song song ,  String IP) {

        setLayout(new FlowLayout(1 , 25, 42));
        setBackground(Color.white);

        download = new JButton("Download");
//        download.setOpaque(false);
//        download.setContentAreaFilled(false);
//        download.setBorderPainted(false);

        download.setPreferredSize(new Dimension(100 , 40));


        add(download);
        download.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(download);
                myFrame.getClient().connect(IP);
                myFrame.getClient().setRequest(IP , "GetSong");
                myFrame.getClient().setSong(song , IP);

            }
        });


        setVisible(true);
    }






    public OptionOfSongPanel(Song song , PlayList playList) {

        setLayout(new FlowLayout(1 , 25, 42));
        setBackground(Color.white);

        delete = new JButton(new ImageIconButton(".\\Icons\\button.png" , 30 , 30 ));
        delete.setOpaque(false);
        delete.setContentAreaFilled(false);
        delete.setBorderPainted(false);


        play = new JButton(new ImageIconButton(".\\Icons\\img_153075.png" , 30 , 30));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);

        delete.setPreferredSize(new Dimension(60 , 40));
        play.setPreferredSize(new Dimension(60 , 40));


        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new DeleteSongPlayListController(myFrame , mainPanel ,playList, song);
            }
        });

        add(play);
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);

                try {
                    new PlaySongController(myFrame ,song ,playList);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });

        setVisible(true);
    }


    public JButton getPlay() {
        return play;
    }
}
