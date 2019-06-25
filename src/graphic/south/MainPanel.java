package graphic.south;

import MusicHandler.MusicThread;
import graphic.MainFrame;
import logic.Album;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainPanel extends JPanel {

    SongInfoPanel songInfoPanel;
    PlayerBarPanel playerBar;
    ValumeBarPanel valumeBar;
    public MainPanel(MainFrame mainFrame) {



        setPreferredSize(new Dimension(150 , 100));
        setLayout(new BoxLayout(this , BoxLayout.LINE_AXIS));
        setBackground(Color.white);

        songInfoPanel = new SongInfoPanel();
        playerBar = new PlayerBarPanel();
        valumeBar = new ValumeBarPanel();

        add(songInfoPanel);
        add(playerBar);
        add(valumeBar);


        mainFrame.add(this , BorderLayout.SOUTH);
        setVisible(true);
    }



    public MainPanel(MainFrame mainFrame, ArrayList<Song> songs, Song song, MusicThread musicThread , Thread thread) {

        setPreferredSize(new Dimension(150 , 100));
        setLayout(new BoxLayout(this , BoxLayout.LINE_AXIS));
        setBackground(Color.white);

        songInfoPanel = new SongInfoPanel();
        playerBar = new PlayerBarPanel(mainFrame , songs  , song,thread , musicThread);
        valumeBar = new ValumeBarPanel();

        add(songInfoPanel);
        add(playerBar);
        add(valumeBar);


        mainFrame.add(this , BorderLayout.SOUTH);
        setVisible(true);
    }



    public MainPanel(MainFrame mainFrame, Song song, MusicThread musicThread , Thread thread , Album album) {

        setPreferredSize(new Dimension(150 , 100));
        setLayout(new BoxLayout(this , BoxLayout.LINE_AXIS));
        setBackground(Color.white);

        songInfoPanel = new SongInfoPanel();
        playerBar = new PlayerBarPanel(mainFrame , song,thread , musicThread , album);
        valumeBar = new ValumeBarPanel();

        add(songInfoPanel);
        add(playerBar);
        add(valumeBar);


        mainFrame.add(this , BorderLayout.SOUTH);
        setVisible(true);
    }




    public MainPanel(MainFrame mainFrame, Song song, MusicThread musicThread , Thread thread , PlayList playList) {

        setPreferredSize(new Dimension(150 , 100));
        setLayout(new BoxLayout(this , BoxLayout.LINE_AXIS));
        setBackground(Color.white);

        songInfoPanel = new SongInfoPanel();
        playerBar = new PlayerBarPanel(mainFrame , song,thread , musicThread , playList);
        valumeBar = new ValumeBarPanel();

        add(songInfoPanel);
        add(playerBar);
        add(valumeBar);


        mainFrame.add(this , BorderLayout.SOUTH);
        setVisible(true);
    }







    public SongInfoPanel getSongInfoPanel() {
        return songInfoPanel;
    }

    public PlayerBarPanel getPlayerBar() {
        return playerBar;
    }


}


