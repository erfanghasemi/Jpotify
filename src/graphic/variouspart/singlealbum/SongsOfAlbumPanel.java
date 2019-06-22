package graphic.variouspart.singlealbum;

import javax.swing.*;
import java.awt.*;

public class SongsOfAlbumPanel extends JPanel {

    JButton more , delete;

    public SongsOfAlbumPanel() {

        setLayout(new FlowLayout(1 , 25, 42));

        more = new JButton("More");
        delete = new JButton("Delete");

        more.setPreferredSize(new Dimension(70 , 30));
        delete.setPreferredSize(new Dimension(73 , 30));

        add(more);
        add(delete);

        setVisible(true);
    }
}
