package graphic.north;

import javax.swing.*;
import java.awt.*;

public class JpotyfyIconPanel extends JPanel {

    JLabel jpotifyIcon;

    public JpotyfyIconPanel() {

        setBackground(Color.white);
        setLayout(new BorderLayout());

        jpotifyIcon = new JLabel();


        jpotifyIcon.setPreferredSize(new Dimension(50 , 50));

        add(jpotifyIcon , BorderLayout.WEST);

    }
}
