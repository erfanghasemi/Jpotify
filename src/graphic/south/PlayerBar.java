package graphic.south;

import graphic.variouspart.singleplaylist.OptionOfPlayListPanel;
import graphic.west.PlaylistPanel;

import javax.swing.*;
import java.awt.*;

public class PlayerBar extends JPanel {

    JPanel optionOfPlayPanel , playSliderPanel;
    JSlider bar;
    JLabel endLabelTime;
    JLabel startlabelTime;
    JButton play , addToShare , addToFavourite , pause , nextSong , previousSong;


    public PlayerBar() {

        setPreferredSize(new Dimension(250, 250));
        setBackground(Color.white);
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

        optionOfPlayPanel = new JPanel();
        playSliderPanel = new JPanel();

        playSliderPanel.setBackground(Color.white);
        playSliderPanel.setLayout(new GridBagLayout());

        optionOfPlayPanel.setBackground(Color.white);

        startlabelTime = new JLabel("2:32      ");
        bar = new JSlider(0 , 100 , 50);
        endLabelTime = new JLabel("    5:36");


        bar.setEnabled(true);
        bar.setPaintTicks(false);
        bar.setPaintLabels(false);
        bar.setPreferredSize(new Dimension(400 , 25));

        playSliderPanel.add(startlabelTime);
        playSliderPanel.add(bar);
        playSliderPanel.add(endLabelTime);


        play = new JButton("Play");
        addToFavourite = new JButton("Favourite");
        addToShare = new JButton("Share");
        pause = new JButton("Pause");
        nextSong = new JButton("Next");
        previousSong = new JButton("Pervious");

        optionOfPlayPanel.add(addToFavourite);
        optionOfPlayPanel.add(previousSong);
        optionOfPlayPanel.add(pause);
        optionOfPlayPanel.add(play);
        optionOfPlayPanel.add(nextSong);
        optionOfPlayPanel.add(addToShare);


        add(playSliderPanel);
        add(optionOfPlayPanel);

        setVisible(true);
    }
}
