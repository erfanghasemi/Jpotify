package graphic.north;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {

    JLabel userNameLabel;

    public ProfilePanel() {
        setPreferredSize(new Dimension(120 , 25));
        setBackground(Color.white);
        setLayout(new FlowLayout(1 , 0 , 25));

        userNameLabel = new JLabel();
        userNameLabel.setFont(new Font("Serif", Font.BOLD, 15));

        add(userNameLabel);
        setVisible(true);
    }

    public void setUserName(String username){
        userNameLabel.setText(username);
    }
}
