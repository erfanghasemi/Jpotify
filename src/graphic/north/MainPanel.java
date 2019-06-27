package graphic.north;

import graphic.MainFrame;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    SearchPanel searchPanel;
    ProfilePanel profilePanel;
    JpotyfyLabelPanel jpotyfyIconPanel;

    public MainPanel(MainFrame mainFrame) {

        setPreferredSize(new Dimension(150 , 70));
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;

        setBackground(Color.white);

        searchPanel= new SearchPanel();
        profilePanel = new ProfilePanel();
        jpotyfyIconPanel = new JpotyfyLabelPanel();

        JPanel invisble1 = new JPanel();
        invisble1.setBackground(Color.white);
        c.ipady = 60;
        c.ipadx = 30;
        c.gridx = 0;
        c.gridy = 0;
        add(invisble1 , c);

        c.ipady = 60;
        c.ipadx = 40;
        c.gridx = 1;
        c.gridy = 0;
        add(jpotyfyIconPanel , c);


        JPanel invisble2 = new JPanel();
        invisble2.setBackground(Color.white);
        c.ipady = 60;
        c.ipadx = 170;
        c.gridx = 2;
        c.gridy = 0;
        add(invisble2 , c);


        c.ipady = 25;
        c.ipadx = 150;
        c.gridx = 3;
        c.gridy = 0;
        add(searchPanel , c);

        JPanel invisble3 = new JPanel();
        invisble3.setBackground(Color.white);
        c.ipady = 60;
        c.ipadx = 170;
        c.gridx = 4;
        c.gridy = 0;
        add(invisble3 , c);

        c.ipady = 35;
        c.ipadx = 80;
        c.gridx = 5;
        c.gridy = 0;
        add(profilePanel ,c );


        mainFrame.add(this , BorderLayout.NORTH);

        this.repaint();
        this.validate();
        mainFrame.repaint();
        mainFrame.validate();
        setVisible(true);
    }

    public ProfilePanel getProfilePanel() {
        return profilePanel;
    }
}
