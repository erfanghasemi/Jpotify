package graphic.north;

import javax.swing.*;
import java.awt.*;

public class JpotyfyLabelPanel extends JPanel {

    JLabel jpotifyLabel;

    public JpotyfyLabelPanel() {

        setBackground(Color.white);
        setLayout(new BorderLayout());

        jpotifyLabel = new JLabel("Jpotify");

        jpotifyLabel.setFont(new Font("Calibri", Font.BOLD, 45));

        jpotifyLabel.setPreferredSize(new Dimension(150 , 60));

        add(jpotifyLabel, BorderLayout.WEST);

    }
}
