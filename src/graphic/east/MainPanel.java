package graphic.east;

import graphic.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    public MainPanel(MainFrame mainFrame) {

        setPreferredSize(new Dimension(120 , 250));

        setBackground(Color.green);
        mainFrame.add(this , BorderLayout.EAST);
        setVisible(true);

    }
}
