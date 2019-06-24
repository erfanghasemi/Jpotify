package graphic.south;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel(JFrame mainFrame) {

        setPreferredSize(new Dimension(150 , 100));
        setLayout(new BoxLayout(this , BoxLayout.LINE_AXIS));
        setBackground(Color.white);

        SongInfoPanel playListOption = new SongInfoPanel();
        PlayerBar playerBar = new PlayerBar();
        ValumeBar valumeBar = new ValumeBar();

        add(playListOption);
        add(playerBar);
        add(valumeBar);


        mainFrame.add(this , BorderLayout.SOUTH);
        setVisible(true);
    }
}
