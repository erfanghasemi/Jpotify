package graphic.west;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Controller.libraryControlller.AlbumsController;
import logic.Controller.libraryControlller.SaveFileController;
import logic.Controller.libraryControlller.SongsController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryPanel extends JPanel {


    public JButton songs , albums, addSong;
    public TitledBorder titledBorder;

    public LibraryPanel( ) {

        setBackground(Color.white);
        setLayout(new GridLayout(3 , 2 ));

        songs = new JButton("Songs" );

        albums = new JButton("Albums");

        addSong = new JButton("Add Song");


        add(songs);
        add(albums);
        add(addSong);

        addSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaveFileController();
            }
        });

        songs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(songs);
                MainPanel mainPanel = myFrame.getCenter();
                new SongsController(mainPanel);
            }
        });

        albums.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(songs);
                MainPanel mainPanel = myFrame.getCenter();
                new AlbumsController(mainPanel);
            }
        });


        songs.setVisible(true);
        albums.setVisible(true);
        addSong.setVisible(true);

        titledBorder = new TitledBorder("Library");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setTitlePosition(TitledBorder.TOP);
        titledBorder.setTitleColor(Color.BLACK);
        titledBorder.setTitleFont(new Font("Serif", Font.BOLD, 12));
        setBorder(titledBorder);

        setVisible(true);
    }
}
