package graphic.variouspart.singlealbum;

import javax.swing.*;
import java.awt.*;

public class LabelOfAlbumPanel extends JPanel {

    JLabel artistLabel ,titleLabel;

    public LabelOfAlbumPanel(String artistName , String albumName) {

        setLayout(new GridLayout(2 , 1 , 5 , 5));


        titleLabel = new JLabel(albumName);
        artistLabel = new JLabel(artistName);

        titleLabel.setFont(new Font("Serif", Font.BOLD, 12));
        artistLabel.setFont(new Font("Serif", Font.BOLD, 12));

        add(titleLabel);
        add(artistLabel);

        setVisible(true);
    }
}
