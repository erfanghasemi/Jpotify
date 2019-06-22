package graphic.variouspart.additem;

import logic.Controller.libraryControlller.SubmitNewPlayListController;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlayListPanel extends JPanel {

    JPanel informationPanel , submitPanel;
    JTextField playListName , firstSong , secondSong , thirdSong , forthSong , fifthSong;
    JLabel playListNameLabel , firstSongLabel , secondSongLabel , thirdSongLabel , forthSongLabel , fifthSongLabel;
    JButton addPlayList;

    public AddPlayListPanel() {

        informationPanel = new JPanel();
        submitPanel = new JPanel();

        setLayout(new BorderLayout());
        informationPanel.setLayout(new GridLayout( 6 , 2 , 10 , 10));
        submitPanel.setLayout(new BorderLayout());

        playListName = new JTextField("");
        firstSong = new JTextField("");
        secondSong = new JTextField("");
        thirdSong = new JTextField("");
        forthSong = new JTextField("");
        fifthSong = new JTextField("");

        playListNameLabel = new JLabel("Title  :  ");
        firstSongLabel = new JLabel("FirstSong  :  ");
        secondSongLabel = new JLabel("SecondSong  :  ");
        thirdSongLabel = new JLabel("ThirdSong  :  ");
        forthSongLabel = new JLabel("ForthSong  :  ");
        fifthSongLabel = new JLabel("FifthSong  :  ");

        addPlayList  = new JButton("Add");

        addPlayList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SubmitNewPlayListController();
            }
        });


        secondSong.setPreferredSize(new Dimension(100, 50));
        secondSong.setMaximumSize(new Dimension(100, 50));

        informationPanel.add(playListNameLabel);
        informationPanel.add(playListName);

        informationPanel.add(firstSongLabel);
        informationPanel.add(firstSong);

        informationPanel.add(secondSongLabel);
        informationPanel.add(secondSong);

        informationPanel.add(thirdSongLabel);
        informationPanel.add(thirdSong);

        informationPanel.add(forthSongLabel);
        informationPanel.add(forthSong);

        informationPanel.add(fifthSongLabel);
        informationPanel.add(fifthSong);

        submitPanel.add(addPlayList , BorderLayout.CENTER);

        TitledBorder titledBorder = new TitledBorder("Add PlayList");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setTitlePosition(TitledBorder.TOP);
        titledBorder.setTitleColor(Color.BLACK);
        titledBorder.setTitleFont(new Font("Serif", Font.BOLD, 12));
        setBorder(titledBorder);

        add(informationPanel , BorderLayout.NORTH);
        add(submitPanel , BorderLayout.AFTER_LAST_LINE);

        setVisible(true);
    }

}
