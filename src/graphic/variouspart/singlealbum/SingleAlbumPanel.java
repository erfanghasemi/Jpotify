package graphic.variouspart.singlealbum;

import logic.Album;

import javax.swing.*;
import java.awt.*;

public class SingleAlbumPanel extends JPanel {

    AlbumImagePanel albumImagePanel;
    SongsOfAlbumPanel songsOfAlbumPanel;
    LabelOfAlbumPanel labelOfAlbumPanel;
    private Album album;

    public SingleAlbumPanel(String artist , String title , Image artWork , Album album) {

        this.album = album;

        setPreferredSize(new Dimension(620 , 120));
        setMinimumSize(new Dimension(620 , 120));
        setMaximumSize(new Dimension(1300, 120));

        setBackground(Color.black);

        setLayout(new BorderLayout());

        albumImagePanel = new AlbumImagePanel(artWork);
        songsOfAlbumPanel = new SongsOfAlbumPanel(album);
        labelOfAlbumPanel = new LabelOfAlbumPanel(artist , title);

        add(albumImagePanel , BorderLayout.WEST);
        add(songsOfAlbumPanel , BorderLayout.EAST);
        add(labelOfAlbumPanel , BorderLayout.CENTER);

        setVisible(true);
    }

    public Album getAlbum() {
        return album;
    }
}
