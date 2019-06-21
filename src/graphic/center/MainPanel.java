package graphic.center;

import graphic.variouspart.singlesong.SingleSongPanel;


import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainPanel extends JPanel {



    public MainPanel(JFrame mainFrame) {

        setBackground(Color.darkGray);
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(this);
        mainFrame.add( scrollPane, BorderLayout.CENTER);
        setVisible(true);

    }


}
