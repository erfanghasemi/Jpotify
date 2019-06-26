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

    public void run (){
        String folder="C:\\Users\\Mahdi\\Desktop\\New folder (2)";

        try
        {
            Socket skt = serverSocket.accept();
            InputStream is= skt.getInputStream();



            byte[] bytes= new byte[1024*16];

            DataInputStream dis = new DataInputStream(skt.getInputStream());
            String ext  = dis.readUTF();

            System.out.println(ext);

            System.out.println("extension read");



            String path = folder + "." + ext;
            File f= new File(path);
            OutputStream output = new FileOutputStream(f);
            while(is.read(bytes)>0)
            {
                output.write(bytes);
                System.out.println("byte read");
            }
            System.out.println("Done!!!");
            Song song = new Song(f.getPath());
            MusicThread musicThread = new MusicThread(song);
            Thread thread = new Thread(musicThread);
            thread.start();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


}
