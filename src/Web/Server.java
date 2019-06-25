package Web;

import MusicHandler.MusicThread;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    ServerSocket serverSocket;

    public Server () throws IOException {
        serverSocket = new ServerSocket(1379);
    }

    public void run(){

        try {
            Socket client = this.serverSocket.accept();
            InputStream inputStreamReader = client.getInputStream();
            MusicThread musicThread = new MusicThread(inputStreamReader);
            Thread thread = new Thread(musicThread);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
