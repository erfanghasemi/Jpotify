package graphic.north;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {

    JLabel userName;

    public ProfilePanel() {
        setPreferredSize(new Dimension(120 , 25));
        setBackground(Color.white);

        userName = new JLabel("Erfan Ghasemi");

        add(userName);
        setVisible(true);
    }
}
