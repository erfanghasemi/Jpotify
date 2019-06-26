package graphic.south;

import MusicHandler.MuteListener;
import MusicHandler.VolumeBarListener;

import javax.swing.*;
import java.awt.*;

public class ValumeBarPanel extends JPanel {

    JPanel topPanel , bottompanel;
    JSlider valumeBar;
    JLabel minimumValue, maximumValue;
    JButton mute;

    public ValumeBarPanel() {

        setPreferredSize(new Dimension(120 , 250));
        setMaximumSize(new Dimension(60 , 250));
        setMinimumSize(new Dimension(60 , 250));

        setBackground(Color.white);
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

        topPanel = new JPanel();
        bottompanel =new JPanel();

        topPanel.setLayout(new GridBagLayout());
        topPanel.setBackground(Color.WHITE);

        bottompanel.setBackground(Color.WHITE);

        valumeBar = new JSlider(0 , 100 , 50);
        maximumValue = new JLabel("100");
        minimumValue = new JLabel("0");
        mute = new JButton("Mute");

        valumeBar.setMinimumSize(new Dimension(90 ,25));
        mute.setMaximumSize(new Dimension(30 , 25));
        mute.addActionListener(new MuteListener());

        valumeBar.setEnabled(true);
        valumeBar.setPaintTicks(false);
        valumeBar.setPaintLabels(false);
        valumeBar.addChangeListener(new VolumeBarListener());


        topPanel.add(minimumValue);
        topPanel.add(valumeBar);
        topPanel.add(maximumValue);

        bottompanel.add(mute);

        add(topPanel);
        add(bottompanel);

        setVisible(true);
    }

}
