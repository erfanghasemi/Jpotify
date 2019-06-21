package graphic.variouspart.singlealbum;

import javax.swing.*;
import java.awt.*;

public class SongsOfAlbumPanel extends JPanel {

    JButton more;

    public SongsOfAlbumPanel() {

        setLayout(new FlowLayout(1 , 25, 42));

        more = new JButton("More");

        more.setPreferredSize(new Dimension(70 , 30));

        add(more);

        setVisible(true);
    }
}
