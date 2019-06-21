package graphic.variouspart.singlesong;

import javax.swing.*;
import java.awt.*;

public class LabelOfSongPanel extends JPanel {

    JLabel artistLabel , albumLabel , titleLabel;

    public LabelOfSongPanel(String artistName , String albumName , String titleName) {

        setLayout(new GridLayout(3 , 1 , 5 , 5));

        titleLabel = new JLabel(titleName);
        albumLabel = new JLabel(albumName);
        artistLabel = new JLabel(artistName);

        titleLabel.setFont(new Font("Serif", Font.BOLD, 12));
        albumLabel.setFont(new Font("Serif", Font.BOLD, 12));
        artistLabel.setFont(new Font("Serif", Font.BOLD, 12));


        add(titleLabel);
        add(albumLabel);
        add(artistLabel);

        setVisible(true);
    }
}
