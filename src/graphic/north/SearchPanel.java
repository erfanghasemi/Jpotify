package graphic.north;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel {

    JTextField fieldOfSearch;

    public SearchPanel() {
        setPreferredSize(new Dimension(150 , 30));
        setBackground(Color.white);
        setLayout(new BorderLayout());

        fieldOfSearch = new JTextField("Search");
        fieldOfSearch.setBorder(null);
        add(fieldOfSearch , BorderLayout.CENTER);

        setVisible(true);
    }
}
