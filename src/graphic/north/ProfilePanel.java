package graphic.north;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {

    JLabel userName;

    public ProfilePanel() {
        setPreferredSize(new Dimension(60 , 30));
        setBackground(Color.BLUE);

        userName = new JLabel("Erfan Ghasemi");

        add(userName);
        setVisible(true);
    }
}
