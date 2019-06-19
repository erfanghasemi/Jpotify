package graphic.south;

import javax.swing.*;
import java.awt.*;

public class NorthOfPlayBar extends JPanel {

    JSlider bar;
    JLabel endLabelTime;
    JLabel startlabelTime;

    public NorthOfPlayBar() {
        setBackground(Color.WHITE);
        setLayout(new GridBagLayout());


        startlabelTime = new JLabel("2:32      ");
        bar = new JSlider(0 , 100 , 50);
        endLabelTime = new JLabel("    5:36");


        bar.setEnabled(true);
        bar.setPaintTicks(false);
        bar.setPaintLabels(false);
        bar.setPreferredSize(new Dimension(350 , 50));



        add(startlabelTime );
        add(bar);
        add(endLabelTime);

        setVisible(true);
    }
}
