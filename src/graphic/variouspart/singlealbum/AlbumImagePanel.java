package graphic.variouspart.singlealbum;

import javax.swing.*;
import java.awt.*;

public class AlbumImagePanel extends JPanel {

    JLabel artWorkLabel;
    ImageIcon imageIcon;

    public AlbumImagePanel(Image artWork) {

        artWorkLabel = new JLabel();
        Image image = artWork;
        Image newImg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);

        artWorkLabel.setIcon(imageIcon);


        artWorkLabel.setPreferredSize(new Dimension(120 , 120));
        artWorkLabel.setMinimumSize(new Dimension(120 , 120));
        artWorkLabel.setMaximumSize(new Dimension(120 , 120));

        add(artWorkLabel);

    }
}
