package graphic.north;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {

    JLabel userNameLabel;

    public ProfilePanel() {
        setPreferredSize(new Dimension(120 , 25));
        setBackground(Color.white);

        userNameLabel = new JLabel();

        add(userNameLabel);
        setVisible(true);
    }

    public void setUserName(String username){
        userNameLabel.setText(username);
    }
}
