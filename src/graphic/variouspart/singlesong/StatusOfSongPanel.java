package graphic.variouspart.singlesong;

import javax.swing.*;
import java.awt.*;

public class StatusOfSongPanel extends JPanel {

    JButton delete , play;

    public StatusOfSongPanel() {

        setLayout(new FlowLayout(1 , 25, 42));



        delete = new JButton("Delete");
        play = new JButton("Play");

        delete.setPreferredSize(new Dimension(70 , 30));
        play.setPreferredSize(new Dimension(60 , 30));

        add(delete);
        add(play);


        setVisible(true);
    }
}
