package graphic.west;

import javax.swing.*;
import java.awt.*;

public class NorthOfPlayBar extends JPanel {

    JSlider bar;
    JLabel endLabelTime;
    JLabel startlabelTime;

    public NorthOfPlayBar() {
        setBackground(Color.BLUE);
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(250 , 50));

        bar = new JSlider();
        startlabelTime = new JLabel("2:32");
        endLabelTime = new JLabel("5:36");

        add(startlabelTime);
        add(bar);
        add(endLabelTime);

        setVisible(true);
    }
}
