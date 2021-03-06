package graphic.variouspart.singlesong;

import graphic.variouspart.ImageItemPanel;
import logic.Album;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.awt.*;

public class SingleSongPanel extends JPanel {

    LabelOfSongPanel labelOfSongPanel;
    ImageItemPanel imageOfSongPanel;
    OptionOfSongPanel statusOfSongPanel;
    private Song song;
    private Album album;
    private PlayList playList;


    public SingleSongPanel(String artistName , String albumName , String titleName , Image artWork , Song song ,PlayList playList) {

        this.song = song;
        this.playList = playList;

        setPreferredSize(new Dimension(620 , 120));
        setMinimumSize(new Dimension(620 , 120));
        setMaximumSize(new Dimension(1300, 120));

        setLayout(new BorderLayout());
        setBackground(Color.white );

        labelOfSongPanel = new LabelOfSongPanel(artistName , albumName , titleName);
        imageOfSongPanel = new ImageItemPanel(artWork);
        statusOfSongPanel = new OptionOfSongPanel(song , playList);

        setBorder(BorderFactory.createLineBorder(Color.black, 1));

        add(imageOfSongPanel , BorderLayout.WEST);
        add(labelOfSongPanel , BorderLayout.CENTER);
        add(statusOfSongPanel , BorderLayout.EAST);

        setVisible(true);
    }

    public SingleSongPanel(String artistName , String albumName , String titleName , Image artWork , Song song ,String IP) {

        this.song = song;

        setPreferredSize(new Dimension(620 , 120));
        setMinimumSize(new Dimension(620 , 120));
        setMaximumSize(new Dimension(1300, 120));

        setLayout(new BorderLayout());
        setBackground(Color.white );

        labelOfSongPanel = new LabelOfSongPanel(artistName , albumName , titleName);
        imageOfSongPanel = new ImageItemPanel(artWork);
        statusOfSongPanel = new OptionOfSongPanel(song , IP);

        setBorder(BorderFactory.createLineBorder(Color.black, 1));

        add(imageOfSongPanel , BorderLayout.WEST);
        add(labelOfSongPanel , BorderLayout.CENTER);
        add(statusOfSongPanel , BorderLayout.EAST);

        setVisible(true);
    }

    public SingleSongPanel(String artistName , String albumName , String titleName , Image artWork , Song song , Album album) {

        this.song = song;
        this.album = album;

        setPreferredSize(new Dimension(620 , 120));
        setMinimumSize(new Dimension(620 , 120));
        setMaximumSize(new Dimension(1300, 120));

        setLayout(new BorderLayout());
        setBackground(Color.white );

        labelOfSongPanel = new LabelOfSongPanel(artistName , albumName , titleName);
        imageOfSongPanel = new ImageItemPanel(artWork);
        statusOfSongPanel = new OptionOfSongPanel(song , album);

        setBorder(BorderFactory.createLineBorder(Color.black, 1));


        add(imageOfSongPanel , BorderLayout.WEST);
        add(labelOfSongPanel , BorderLayout.CENTER);
        add(statusOfSongPanel , BorderLayout.EAST);

        setVisible(true);
    }


    public SingleSongPanel(String artistName , String albumName , String titleName , Image artWork , Song song) {

        this.song = song;

        setPreferredSize(new Dimension(620 , 120));
        setMinimumSize(new Dimension(620 , 120));
        setMaximumSize(new Dimension(1300, 120));

        setLayout(new BorderLayout());
        setBackground(Color.white );

        labelOfSongPanel = new LabelOfSongPanel(artistName , albumName , titleName);
        imageOfSongPanel = new ImageItemPanel(artWork);
        statusOfSongPanel = new OptionOfSongPanel(song);

        setBorder(BorderFactory.createLineBorder(Color.black, 1));

        add(imageOfSongPanel , BorderLayout.WEST);
        add(labelOfSongPanel , BorderLayout.CENTER);
        add(statusOfSongPanel , BorderLayout.EAST);

        setVisible(true);
    }

    public OptionOfSongPanel getStatusOfSongPanel() {
        return statusOfSongPanel;
    }

    public Song getSong() {
        return song;
    }
}
