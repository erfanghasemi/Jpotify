package graphic.north;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Controller.libraryControlller.SearchSongController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchPanel extends JPanel {

    JTextField fieldOfSearch;
        JButton submitSearch;

        public SearchPanel() {
        setPreferredSize(new Dimension(200 , 25));
        setBackground(Color.white);
        setLayout(new BorderLayout());

        fieldOfSearch = new JTextField();
        submitSearch= new JButton("Search");

        submitSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(submitSearch);
                MainPanel mainPanel = myFrame.getCenter();
                new SearchSongController(mainPanel ,myFrame.getNorth().searchPanel);
            }
        });

        fieldOfSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(submitSearch);
                MainPanel mainPanel = myFrame.getCenter();
                new SearchSongController(mainPanel ,myFrame.getNorth().searchPanel);
            }
        });


        submitSearch.setPreferredSize(new Dimension(75,25));
        fieldOfSearch.setPreferredSize(new Dimension(120,25));

        fieldOfSearch.setBackground(Color.lightGray);
        fieldOfSearch.setBorder(null);




        add(fieldOfSearch , BorderLayout.CENTER);
        add(submitSearch , BorderLayout.WEST);

        setVisible(true);
    }

    public String getFieldOfSearchText() {

          return fieldOfSearch.getText();
    }
}
