package graphic.variouspart.singlesong;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SingleSongPanel extends JPanel {

    LabelOfSongPanel labelOfSongPanel;
    ImageOfSongPanel imageOfSongPanel;
    StatusOfSongPanel statusOfSongPanel;

    public SingleSongPanel(String artistName , String albumName , String titleName , Image artWork) {


        setPreferredSize(new Dimension(620 , 120));
        setMinimumSize(new Dimension(620 , 120));
        setMaximumSize(new Dimension(1300, 120));

        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY  );

        labelOfSongPanel = new LabelOfSongPanel(artistName , albumName , titleName);
        imageOfSongPanel = new ImageOfSongPanel(artWork);
        statusOfSongPanel = new StatusOfSongPanel();


        add(imageOfSongPanel , BorderLayout.WEST);
        add(labelOfSongPanel , BorderLayout.CENTER);
        add(statusOfSongPanel , BorderLayout.EAST);



        setVisible(true);
    }

}
