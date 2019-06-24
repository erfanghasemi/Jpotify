package graphic.south;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    SongInfoPanel songInfoPanel;
    PlayerBarPanel playerBar;
    ValumeBarPanel valumeBar;
    public MainPanel(JFrame mainFrame) {



        setPreferredSize(new Dimension(150 , 100));
        setLayout(new BoxLayout(this , BoxLayout.LINE_AXIS));
        setBackground(Color.white);

        songInfoPanel = new SongInfoPanel();
        playerBar = new PlayerBarPanel();
        valumeBar = new ValumeBarPanel();

        add(songInfoPanel);
        add(playerBar);
        add(valumeBar);


        mainFrame.add(this , BorderLayout.SOUTH);
        setVisible(true);
    }

    public SongInfoPanel getSongInfoPanel() {
        return songInfoPanel;
    }

    public PlayerBarPanel getPlayerBar() {
        return playerBar;
    }


}
