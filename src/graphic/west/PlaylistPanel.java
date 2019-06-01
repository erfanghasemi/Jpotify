package graphic.west;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class PlaylistPanel extends JPanel {

    TitledBorder titledBorder;
    JButton newPlayList;
    JList playLists;
    String[] playListNames = {"Share" , "Favourite" , "Pop" , "Rap" , "Jazz" , "HipHop" ,"HipHop","HipHop","HipHop","HipHop","HipHop","HipHop","HipHop"};

    public PlaylistPanel() {

        setBackground(Color.white);
        setLayout(new BorderLayout());

        newPlayList = new JButton(" New Playlist");
        playLists = new JList(playListNames);
        JScrollPane scrollPane = new JScrollPane(playLists);

        add(newPlayList, BorderLayout.NORTH);
        add(scrollPane , BorderLayout.CENTER);


        titledBorder = new TitledBorder("Playlist");
        titledBorder.setTitleJustification(TitledBorder.CENTER);
        titledBorder.setTitlePosition(TitledBorder.TOP);
        titledBorder.setTitleColor(Color.BLACK);
        titledBorder.setTitleFont(new Font("Serif", Font.BOLD, 12));
        setBorder(titledBorder);

        setVisible(true);
    }
}
