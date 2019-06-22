package graphic.variouspart.singlesong;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Controller.libraryControlller.DeleteSongController;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusOfSongPanel extends JPanel {

    JButton delete , play;

    public StatusOfSongPanel(Song song) {

        setLayout(new FlowLayout(1 , 25, 42));



        delete = new JButton("Delete");
        play = new JButton("Play");

        delete.setPreferredSize(new Dimension(70 , 30));
        play.setPreferredSize(new Dimension(60 , 30));


        add(delete);
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(delete);
                MainPanel mainPanel = myFrame.getCenter();
                new DeleteSongController( song , mainPanel);
            }
        });

        add(play);


        setVisible(true);
    }
}
