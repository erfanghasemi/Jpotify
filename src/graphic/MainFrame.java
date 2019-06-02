package graphic;

import graphic.east.MainPanel;


import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    graphic.east.MainPanel east;
    graphic.west.MainPanel west;
    graphic.north.MainPanel north;
    graphic.south.MainPanel south;
    graphic.center.MainPanel center;
    Image iconFrame;


    public MainFrame(){

        east = new graphic.east.MainPanel();
        west = new graphic.west.MainPanel();
        north  = new graphic.north.MainPanel();
        south = new graphic.south.MainPanel();
        center = new graphic.center.MainPanel();

        iconFrame = Toolkit.getDefaultToolkit().getImage("D:\\Jpotify\\src\\graphic\\photo_2019-05-17_15-51-50.jpg");


        getContentPane().add(east , BorderLayout.EAST);
        getContentPane().add(west , BorderLayout.WEST);
        getContentPane().add(north , BorderLayout.NORTH);
        getContentPane().add(south, BorderLayout.SOUTH);
        getContentPane().add(center , BorderLayout.CENTER);

        setLocation(new Point(300 , 50));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setDefaultLookAndFeelDecorated(true);
        setIconImage(iconFrame);
        setSize(950 , 750 );
        setVisible(true);
    }





}
