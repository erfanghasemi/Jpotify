package graphic.variouspart.singleplaylist;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Album;
import logic.Controller.libraryControlller.SongsShowController;
import logic.PlayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.PlatformLoggingMXBean;

public class OptionOfPlayListPanel extends JPanel {


    JButton more , delete , rename , addSong;

    public OptionOfPlayListPanel(PlayList playList) {

        setLayout(new GridLayout(2 , 2 , 5 , 5));

        more = new JButton("More");
        delete = new JButton("Delete");
        rename = new JButton("Rename");
        addSong = new JButton("Add Song");


        more.setPreferredSize(new Dimension(70 , 30));
        delete.setPreferredSize(new Dimension(70 , 30));
        rename.setPreferredSize(new Dimension(80 , 30));
        addSong.setPreferredSize(new Dimension(100 , 30));

        add(more);
        more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        add(rename);
        rename.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        add(addSong);
        addSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        setVisible(true);
    }


}
