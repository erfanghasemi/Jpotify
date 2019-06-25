import Web.Client;
import Web.Server;
import graphic.MainFrame;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        //Play play = new Play("G:/flash mashin/dar ham/hayede/(3).MP3");
        Server server = new Server(1379);
        Client client = new Client("127.0.0.1", 1379);
        Thread thread = new Thread(server);
        Thread thread1 = new Thread(client);
        thread.start();
        thread1.start();
    }
}
