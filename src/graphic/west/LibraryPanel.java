package graphic.west;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Controller.libraryControlller.AlbumsController;
import logic.Controller.libraryControlller.SaveFileController;
import logic.Controller.libraryControlller.SongsShowController;

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
                JFileChooser chooser = new JFileChooser();
//        chooser.setCurrentDirectory(new java.io.File("."));
                chooser.setDialogTitle("choosertitle");
                chooser.setAcceptAllFileFilterUsed(false);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
                    System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
                } else {
                    System.out.println("No Selection ");
                }

                String address = chooser.getSelectedFile().getPath();

                new SaveFileController(address);

            }
        });

        songs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(songs);
                MainPanel mainPanel = myFrame.getCenter();
                new SongsShowController(myFrame , mainPanel);
            }
        });

        albums.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(songs);
                MainPanel mainPanel = myFrame.getCenter();
                new AlbumsController(myFrame , mainPanel);
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
