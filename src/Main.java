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



        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();

        Client client = new Client();
        Thread thread1 = new Thread(client);
        thread1.start();
//        client.addIP("192.168.43.63");
//        client.setRequest("192.168.43.63", "SharePlayList");

        MainFrame mainFrame = new MainFrame(client , server);


        //System.out.println(new Song("C:\\Users\\Mahdi\\Desktop\\taylor.mp3").getTitle());


    }
}
