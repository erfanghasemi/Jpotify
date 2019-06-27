package graphic.variouspart.singlealbum;

import graphic.MainFrame;
import graphic.center.MainPanel;
import graphic.variouspart.ImageIconButton;
import logic.Album;
import logic.Controller.libraryControlller.AlbumsController;
import logic.Controller.libraryControlller.DeleteSongController;
import logic.Controller.libraryControlller.SongsShowController;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionOfAlbumPanel extends JPanel {

    JButton more , delete;

    public OptionOfAlbumPanel(Album album) {

        setLayout(new FlowLayout(1 , 25, 42));
        setBackground(Color.white);


        more = new JButton(new ImageIconButton(".\\Icons\\img_55392.png" , 30 , 30));
        more.setOpaque(false);
        more.setContentAreaFilled(false);
        more.setBorderPainted(false);


        delete = new JButton(new ImageIconButton(".\\Icons\\button.png" ,30,30  ));
        delete.setOpaque(false);
        delete.setContentAreaFilled(false);
        delete.setBorderPainted(false);

        more.setPreferredSize(new Dimension(60 , 40));
        delete.setPreferredSize(new Dimension(60 , 40));

        add(more);

        more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new SongsShowController(myFrame , mainPanel , album);


            }
        });

        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                for (Song song : album.getAlbumSongs()) {
                    new DeleteSongController(song , mainPanel , myFrame);
                }
                new AlbumsController(myFrame , mainPanel);
            }
        });

        setVisible(true);
    }
}
