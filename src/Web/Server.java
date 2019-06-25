package Web;

import MusicHandler.MusicThread;
import logic.Song;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{

    ServerSocket serverSocket;

    public Server (int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void run(){

        try {
            Socket client = this.serverSocket.accept();
            //DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            DataInputStream in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            byte[] bytes = new byte[1024];

            in.read(bytes);
            System.out.println(bytes);

            File file = new File("C:\\Users\\Mahdi\\Desktop\\New folder (2)");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(bytes);

            Song song = new Song(file.getPath());

            MusicThread musicThread = new MusicThread(song);
            Thread thread = new Thread(musicThread);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
