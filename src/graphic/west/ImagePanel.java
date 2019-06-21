package graphic.west;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ImagePanel extends JPanel {

    JLabel artWorkLabel;

    public ImagePanel() {


        artWorkLabel = new JLabel();
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\01RAYANEH\\Desktop\\Taylor_Swift_-_1989.png");
        Image image = imageIcon.getImage();
        Image newImg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newImg);

        artWorkLabel.setIcon(imageIcon);

        artWorkLabel.setPreferredSize(new Dimension(200 , 200));
        add(artWorkLabel);

        setVisible(true);
    }
}
