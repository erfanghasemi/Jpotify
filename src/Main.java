import MusicHandler.MusicThread;
import Web.Client;
import Web.Server;
import graphic.MainFrame;
import logic.Song;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        MainFrame mainFrame = new MainFrame();
        Server server = new Server(1379);
        Client client = new Client("127.0.0.1", 1379);
        Thread thread = new Thread(server);
        Thread thread1 = new Thread(client);
        thread.start();
        thread1.start();
        Song song = new Song("C:\\Users\\Mahdi\\Desktop\\New folder (2)");
        MusicThread musicThread = new MusicThread(song);
        Thread thread2 = new Thread(musicThread);
        thread2.start();
        File file=new File("C:\\Users\\Mahdi\\Desktop\\bollywood_groove-kevin_macleod.mp3");
        String name=file.getName();
        System.out.println(name);
    }
}
