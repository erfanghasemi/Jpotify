import Web.Client;
import Web.Server;
import graphic.MainFrame;
import logic.Song;

import javax.swing.*;
import java.io.IOException;

//import Web.Client;
//import Web.Server;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {


        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        MainFrame mainFrame = new MainFrame();
//        Server server = new Server();
//        Thread thread = new Thread(server);
//        thread.start();
//        Client client = new Client();
//        client.addIP("192.168.43.182");
//        Thread thread1 = new Thread(client);
//        Song song = new Song("C:\\Users\\Mahdi\\Desktop\\bollywood_groove-kevin_macleod.mp3");
//        client.setSong(song);
//        client.setRequest("192.168.43.182" , "GetSong");
//        thread1.start();

    }
}
