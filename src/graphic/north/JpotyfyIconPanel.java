package graphic.north;

import javax.swing.*;
import java.awt.*;

public class JpotyfyIconPanel extends JPanel {

    JLabel jpotifyIcon;

    public JpotyfyIconPanel() {


        setLayout(new BorderLayout());

        jpotifyIcon = new JLabel();
        jpotifyIcon.setBackground(Color.white);


        ImageIcon imageIcon = new ImageIcon("C:\\Users\\01RAYANEH\\Desktop\\iconfinder_spotify_216744.png");
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        imageIcon = new ImageIcon(newimg);


        jpotifyIcon.setIcon(imageIcon);

        jpotifyIcon.setPreferredSize(new Dimension(50 , 50));

        add(jpotifyIcon , BorderLayout.WEST);

    }
}
