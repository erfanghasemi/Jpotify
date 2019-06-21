package graphic.east;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(JFrame mainFrame) {

        setPreferredSize(new Dimension(120 , 250));

        setBackground(Color.GREEN);
        mainFrame.add(this , BorderLayout.EAST);
        setVisible(true);


    }
}
