package graphic.north;

import graphic.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    SearchPanel searchPanel;
    ProfilePanel profilePanel;
    JpotyfyIconPanel jpotyfyIconPanel;

    public MainPanel(MainFrame mainFrame) {

        setPreferredSize(new Dimension(150 , 60));
        setLayout(new FlowLayout(6 , 150 , 8));
        setBackground(Color.white);

        searchPanel= new SearchPanel();
        profilePanel = new ProfilePanel();
        jpotyfyIconPanel = new JpotyfyIconPanel();

        add(jpotyfyIconPanel);
        add(searchPanel);
        add(profilePanel);


        mainFrame.add(this , BorderLayout.NORTH);
        setVisible(true);
    }

    public ProfilePanel getProfilePanel() {
        return profilePanel;
    }
}
