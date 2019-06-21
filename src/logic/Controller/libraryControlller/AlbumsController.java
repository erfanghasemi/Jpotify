package logic.Controller.libraryControlller;

import graphic.center.MainPanel;
import logic.Album;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AlbumsController  {

    protected ArrayList<Album> albums;


    public AlbumsController(MainPanel albumView) {
        albumView.removeAll();


        //code


        albumView.repaint();
        albumView.validate();
        albumView.setVisible(true);


    }
}
