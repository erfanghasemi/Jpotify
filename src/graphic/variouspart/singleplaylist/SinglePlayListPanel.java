package graphic.variouspart.singleplaylist;

import graphic.variouspart.ImageItemPanel;
import logic.PlayList;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.*;
import java.awt.*;

public class SinglePlayListPanel extends JPanel {

    LabelOfPlayListPanel labelOfPlayListPanel;
    OptionOfPlayListPanel optionOfPlayListPanel;
    ImageItemPanel playListImagePanel;
    private PlayList playList;


    public SinglePlayListPanel(String title , Image artWork , PlayList playList) {


        setPreferredSize(new Dimension(620 , 120));
        setMinimumSize(new Dimension(620 , 120));
        setMaximumSize(new Dimension(1300, 120));

        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY );

        labelOfPlayListPanel = new LabelOfPlayListPanel(title);
        optionOfPlayListPanel = new OptionOfPlayListPanel(playList);
        playListImagePanel = new ImageItemPanel(artWork);


        add(labelOfPlayListPanel , BorderLayout.CENTER);
        add(optionOfPlayListPanel , BorderLayout.EAST);
        add(playListImagePanel , BorderLayout.WEST);


        setVisible(true);
    }


}
