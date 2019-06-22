package graphic.variouspart.singlealbum;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Album;
import logic.Controller.libraryControlller.SongsShowController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SongsOfAlbumPanel extends JPanel {

    JButton more , delete;

    public SongsOfAlbumPanel(Album album) {

        setLayout(new FlowLayout(1 , 25, 42));

        more = new JButton("More");
        delete = new JButton("Delete");

        more.setPreferredSize(new Dimension(70 , 30));
        delete.setPreferredSize(new Dimension(73 , 30));

        add(more);

        more.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new SongsShowController(mainPanel , album);

            }
        });
        add(delete);

        setVisible(true);
    }
}
