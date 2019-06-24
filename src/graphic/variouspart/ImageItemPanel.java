package graphic.variouspart;

import javax.swing.*;
import java.awt.*;
import java.util.jar.JarEntry;

public class ImageItemPanel extends JPanel {

    JLabel artWorkLabel;
    ImageIcon imageIcon;

    public ImageItemPanel(Image artWork) {

        setBackground(Color.white);

        artWorkLabel = new JLabel();
        Image image = artWork;
        Image newImg = image.getScaledInstance(100, 120,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);

        artWorkLabel.setIcon(imageIcon);

        artWorkLabel.setPreferredSize(new Dimension(120 , 120));
        artWorkLabel.setMinimumSize(new Dimension(120 , 120));
        artWorkLabel.setMaximumSize(new Dimension(120 , 120));

        add(artWorkLabel);
    }
}