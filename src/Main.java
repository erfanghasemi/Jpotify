import Web.Server;
import graphic.MainFrame;

import java.io.IOException;

//import Web.Client;
//import Web.Server;

public class Main {

    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        Server server = new Server(8888);
        Thread thread = new Thread(server);
        thread.start();

    }
}
