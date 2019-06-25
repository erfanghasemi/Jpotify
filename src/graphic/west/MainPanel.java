package graphic.west;

import graphic.MainFrame;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class MainPanel extends JPanel {
    ImagePanel imagePanel;
    PlaylistPanel playlistPanel;
    LibraryPanel libraryPanel;

    public MainPanel(MainFrame mainFrame) {

        setPreferredSize(new Dimension(200 , 250));
        setBackground(Color.white);
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

        libraryPanel = new LibraryPanel();
        playlistPanel = new PlaylistPanel();
        imagePanel = new ImagePanel();

        add(libraryPanel);
        add(playlistPanel);
        add(imagePanel);


        mainFrame.add(this , BorderLayout.WEST);
        setVisible(true);
    }

    public PlaylistPanel getPlaylistPanel() {
        return playlistPanel;
    }

    public ImagePanel getImagePanel() {
        return imagePanel;
    }

}
