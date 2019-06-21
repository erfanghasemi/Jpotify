package graphic;


import graphic.east.MainPanel;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private graphic.east.MainPanel east;
    private graphic.west.MainPanel west;
    private graphic.north.MainPanel north;
    private graphic.south.MainPanel south;
    private graphic.center.MainPanel center;
    private Image iconFrame;




    public MainFrame(){

        east = new graphic.east.MainPanel(this);
        west = new graphic.west.MainPanel(this);
        north  = new graphic.north.MainPanel(this);
        south = new graphic.south.MainPanel(this);
        center = new graphic.center.MainPanel(this);


        iconFrame = Toolkit.getDefaultToolkit().getImage("D:\\Jpotify\\src\\graphic\\photo_2019-05-17_15-51-50.jpg");

        setTitle("Jpotify");
        setLocation(new Point(300 , 50));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(iconFrame);
        setSize(950 , 750 );
        setVisible(true);
    }


    public MainPanel getEast() {
        return east;
    }

    public graphic.west.MainPanel getWest() {
        return west;
    }

    public graphic.north.MainPanel getNorth() {
        return north;
    }

    public graphic.south.MainPanel getSouth() {
        return south;
    }

    public graphic.center.MainPanel getCenter() {
        return center;
    }

    public void setEast(MainPanel east) {
        this.east = east;
    }

    public void setWest(graphic.west.MainPanel west) {
        this.west = west;
    }

    public void setNorth(graphic.north.MainPanel north) {
        this.north = north;
    }

    public void setSouth(graphic.south.MainPanel south) {
        this.south = south;
    }

    public void setCenter(graphic.center.MainPanel center) {
        this.center = center;
    }
}
