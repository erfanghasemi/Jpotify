package Web;

import MusicHandler.MusicThread;

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

            FileOutputStream fos = new FileOutputStream("C:\\Users\\Mahdi\\Desktop\\New folder (2)");
            fos.write(bytes);

            MusicThread musicThread = new MusicThread(new FileInputStream("C:\\Users\\Mahdi\\Desktop\\New folder (2)"));
            Thread thread = new Thread(musicThread);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
