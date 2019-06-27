import Web.Client;
import Web.Server;
import graphic.MainFrame;

import java.io.IOException;

//import Web.Client;
//import Web.Server;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        MainFrame mainFrame = new MainFrame();
        Server server = new Server();
        Thread thread = new Thread(server);
        thread.start();
        Client client = new Client();


    }
}
