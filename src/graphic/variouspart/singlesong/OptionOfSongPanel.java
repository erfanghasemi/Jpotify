package graphic.variouspart.singlesong;

import graphic.MainFrame;
import graphic.center.MainPanel;
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

    JButton delete , play;

    public OptionOfSongPanel(Song song) {

        setLayout(new FlowLayout(1 , 25, 42));
        setBackground(Color.white);

        delete = new JButton("Delete");
        play = new JButton("Play");

        delete.setPreferredSize(new Dimension(70 , 30));
        play.setPreferredSize(new Dimension(60 , 30));


        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new DeleteSongController( song , mainPanel);

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

        delete = new JButton("Delete");
        play = new JButton("Play");

        delete.setPreferredSize(new Dimension(70 , 30));
        play.setPreferredSize(new Dimension(60 , 30));


        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new DeleteSongController( song , album ,  mainPanel);

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





    public OptionOfSongPanel(Song song , PlayList playList) {

        setLayout(new FlowLayout(1 , 25, 42));
        setBackground(Color.white);

        delete = new JButton("Delete");
        play = new JButton("Play");

        delete.setPreferredSize(new Dimension(70 , 30));
        play.setPreferredSize(new Dimension(60 , 30));


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
