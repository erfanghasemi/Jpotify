import Web.Client;
import Web.Server;
import graphic.MainFrame;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public Main() throws IOException {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }




//        client.addIP("192.168.43.63");
//        client.setRequest("192.168.43.63", "SharePlayList");

        MainFrame mainFrame = new MainFrame();


        //System.out.println(new Song("C:\\Users\\Mahdi\\Desktop\\taylor.mp3").getTitle());


    }
}
