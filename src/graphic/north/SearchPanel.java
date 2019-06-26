package graphic.north;

import graphic.MainFrame;
import graphic.center.MainPanel;
import graphic.variouspart.ImageIconButton;
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

        submitSearch= new JButton(new ImageIconButton(".\\Icons\\Search-512.png" , 25 , 25));
        submitSearch.setOpaque(false);
        submitSearch.setContentAreaFilled(false);
        submitSearch.setBorderPainted(false);

        submitSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(submitSearch);
                MainPanel mainPanel = myFrame.getCenter();
                new SearchSongController(mainPanel ,myFrame.getNorth().searchPanel);
                fieldOfSearch.setText("");
            }
        });

        fieldOfSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(submitSearch);
                MainPanel mainPanel = myFrame.getCenter();
                new SearchSongController(mainPanel ,myFrame.getNorth().searchPanel);
                fieldOfSearch.setText("");
            }
        });


        submitSearch.setPreferredSize(new Dimension(55,45));
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
