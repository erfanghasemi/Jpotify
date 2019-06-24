package graphic.south;

import javax.swing.*;
import java.awt.*;

public class SongInfoPanel extends JPanel {

    JLabel nameOfSong  , nameOfArtist , nameOfAlbum;

    public SongInfoPanel() {

        setPreferredSize(new Dimension(200, 250));
        setBackground(Color.white);
        setLayout(new GridLayout(3 , 1 , 5 , 5 ));

        nameOfAlbum = new JLabel("1989");
        nameOfArtist = new JLabel("Taylo Swift");
        nameOfSong = new JLabel("Welcome To New York");

        nameOfSong.setHorizontalAlignment(JLabel.CENTER);
        nameOfArtist.setHorizontalAlignment(JLabel.CENTER);
        nameOfAlbum.setHorizontalAlignment(JLabel.CENTER);


        add(nameOfSong);
        add(nameOfAlbum);
        add(nameOfArtist);

        setVisible(true);
    }
}



