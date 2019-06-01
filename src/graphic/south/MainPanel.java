package graphic.south;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel() {

        setPreferredSize(new Dimension(150 , 100));
        setLayout(new BoxLayout(this , BoxLayout.LINE_AXIS));
        setBackground(Color.YELLOW);

        PlayListOption playListOption = new PlayListOption();
        PlayerBar playerBar = new PlayerBar();
        ValumeBar valumeBar = new ValumeBar();

        add(playListOption);
        add(playerBar);
        add(valumeBar);

        setVisible(true);
    }
}
