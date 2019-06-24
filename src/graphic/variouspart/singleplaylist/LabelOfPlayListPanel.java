package graphic.variouspart.singleplaylist;

import javax.swing.*;
import java.awt.*;

public class LabelOfPlayListPanel extends JPanel {

    JLabel titleOfPlayList;

    public LabelOfPlayListPanel(String title) {

        setLayout(new FlowLayout(1 , 5 , 42));
        setBackground(Color.white);

        titleOfPlayList = new JLabel(title);

        titleOfPlayList.setFont(new Font("Serif", Font.BOLD, 20));

        add(titleOfPlayList);

        setVisible(true);
    }
}
