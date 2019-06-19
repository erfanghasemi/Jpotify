package graphic.south;

import javax.swing.*;
import javax.swing.JSlider;
import java.awt.*;

public class ValumeBar extends JPanel {

    JSlider valumeBar;

    public ValumeBar() {

        setPreferredSize(new Dimension(120 , 250));
        setBackground(Color.BLUE);

        valumeBar = new JSlider();

        valumeBar.setSize(30  , 30);

        setVisible(true);

    }
}
