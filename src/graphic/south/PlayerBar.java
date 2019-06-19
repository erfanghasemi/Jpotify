package graphic.south;

import javax.swing.*;
import java.awt.*;

public class PlayerBar extends JPanel {

    SouthOfPlayBar southOfPlayBar;
    NorthOfPlayBar northOfPlayBar;

    public PlayerBar() {

        setPreferredSize(new Dimension(250, 250));
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BorderLayout());

        northOfPlayBar= new NorthOfPlayBar();
        southOfPlayBar = new SouthOfPlayBar();

        add(southOfPlayBar , BorderLayout.SOUTH);
        add(northOfPlayBar , BorderLayout.CENTER);

        setVisible(true);
    }
}
