package logic.Controller.libraryControlller;

import graphic.center.MainPanel;
import graphic.variouspart.additem.AddPlayListPanel;

import java.awt.*;
import java.nio.ByteOrder;

public class AddPlayListShowController {

    AddPlayListPanel addPlayListPanel;

    public AddPlayListShowController(MainPanel view) {

        view.removeAll();

        view.setLayout(new BorderLayout());

        addPlayListPanel = new AddPlayListPanel();

        view.add(addPlayListPanel , BorderLayout.CENTER);
        view.repaint();
        view.validate();
        view.setVisible(true);

    }

}
