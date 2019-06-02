package graphic.south;

import javax.swing.*;
import java.awt.*;

public class PlayListOption extends JPanel {

    JButton addToShare , addToFavourite;


    public PlayListOption() {

        setPreferredSize(new Dimension(60 , 250));
        setBackground(Color.white);
        setLayout( new GridLayout(1 , 2));

        ImageIcon imageIconShare = new ImageIcon("C:\\Users\\01RAYANEH\\Desktop\\share-512 (1).png");
        Image imageShare = imageIconShare.getImage();
        Image newImgShare = imageShare.getScaledInstance(25, 25,  java.awt.Image.SCALE_SMOOTH);
        imageIconShare = new ImageIcon(newImgShare);


        ImageIcon imageIconFavourite = new ImageIcon("C:\\Users\\01RAYANEH\\Desktop\\we_heart_it-512 (1).png");
        Image imageFavourite = imageIconFavourite.getImage();
        Image newImgFavourite = imageFavourite.getScaledInstance(25, 25,  Image.SCALE_SMOOTH);
        imageIconFavourite = new ImageIcon(newImgFavourite);

        addToShare = new JButton(imageIconShare);
        addToFavourite = new JButton(imageIconFavourite);

        addToShare.setPreferredSize(new Dimension(30 , 30));
        addToFavourite.setPreferredSize(new Dimension(30 , 30));

        //addToShare.setBorder(BorderFactory.createEmptyBorder());
        addToShare.setContentAreaFilled(false);

    //    addToFavourite.setBorder(BorderFactory.createEmptyBorder());
        addToFavourite.setContentAreaFilled(false);


        add(addToFavourite);
        add(addToShare);

        setVisible(true);
    }



}
