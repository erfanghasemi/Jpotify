package graphic.south;

import MusicHandler.MusicPause;
import MusicHandler.MusicPlayer;

import javax.swing.*;
import java.awt.*;

public class SouthOfPlayBar extends JPanel {

    JButton paly , addToShare , addToFavourite , pause;

    public SouthOfPlayBar() {
        setBackground(Color.WHITE);
        setLayout(new BoxLayout(this , BoxLayout.LINE_AXIS));


        paly = new JButton("Play");
        addToFavourite = new JButton("Favourite");
        addToShare = new JButton("Share");
        pause = new JButton("Pause");


        add(addToFavourite , BoxLayout.X_AXIS);
        add(paly);
        add(pause);
        add(addToShare);

        setVisible(true);

        MusicPlayer musicPlayer = new MusicPlayer("G:/flash mashin/dar ham/hayede/(3).MP3");

        paly.addActionListener(musicPlayer);

        MusicPause musicPause = new MusicPause(musicPlayer.getUrl());

        pause.addActionListener(musicPause);

    }

}
