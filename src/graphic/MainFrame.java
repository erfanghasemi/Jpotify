package graphic;


import Web.Client;
import Web.Server;
import graphic.east.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {
    private graphic.east.MainPanel east;
    private graphic.west.MainPanel west;
    private graphic.north.MainPanel north;
    private graphic.south.MainPanel south;
    private graphic.center.MainPanel center;
    private Image iconFrame;
    private String userName;
    private JScrollPane scrollPane;
    private Server server;
    private Client client;

    public MainFrame(){

        east = new graphic.east.MainPanel(this);
        west = new graphic.west.MainPanel(this);
        north  = new graphic.north.MainPanel(this);
        south = new graphic.south.MainPanel(this);
        center = new graphic.center.MainPanel(this);
        scrollPane  = new JScrollPane(center);


//        Server server = null;
        try {
            server = new Server();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(server);
        thread.start();




//        Client client = null;
        try {
            client = new Client(this);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        add(center , BorderLayout.CENTER);


        iconFrame = Toolkit.getDefaultToolkit().getImage(".\\Icons\\iconfinder_spotify_216744.png");

        setTitle("Jpotify");
        setLocation(new Point(300 , 50));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setIconImage(iconFrame);
        setSize(950 , 750 );
        setVisible(true);
    }


    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
        this.add(scrollPane , BorderLayout.CENTER);
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
