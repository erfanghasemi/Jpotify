package graphic.north;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public MainPanel(JFrame mainFrame) {

        setPreferredSize(new Dimension(150 , 50));
        setLayout(new FlowLayout(1 , 350, 8));
        setBackground(Color.lightGray);

        SearchPanel searchPanel= new SearchPanel();
        ProfilePanel profilePanel = new ProfilePanel();

        add(searchPanel);
        add(profilePanel);


        mainFrame.add(this , BorderLayout.NORTH);
        setVisible(true);
    }
}
