package graphic.south;


import MusicHandler.MusicThread;
import MusicHandler.PauseListener;
import MusicHandler.PlayListener;
import logic.Song;

import javax.swing.*;
import java.awt.*;

//import MusicHandler.MusicPlayer;

public class SouthOfPlayBar extends JPanel {

    JButton play , addToShare , addToFavourite , pause;

    public SouthOfPlayBar() {
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this , BoxLayout.LINE_AXIS));


        play = new JButton("Play");
        addToFavourite = new JButton("Favourite");
        addToShare = new JButton("Share");
        pause = new JButton("Pause");


        add(addToFavourite , BoxLayout.X_AXIS);
        add(play);
        add(pause);
        add(addToShare);

        setVisible(true);

        Song song = new Song("G:/flash mashin/dar ham/hayede/(3).MP3");

        MusicThread musicThread = new MusicThread(song);

        Thread thread = new Thread(musicThread);

        PlayListener playListener = new PlayListener(thread);

        play.addActionListener(playListener);

        PauseListener pauseListener = new PauseListener(musicThread);

        pause.addActionListener(pauseListener);


    }

}
