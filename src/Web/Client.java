package Web;

import logic.Song;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    private Socket client;
    private Song song;

    public Client (String port, int ip) throws IOException {
        client = new Socket(port, ip);
    }

    public void run (){

        try {
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));
            DataInputStream in = new DataInputStream(new BufferedInputStream(client.getInputStream()));
            File file = new File("D:\\Music\\Moein - Donyaye Eshgh\\02 Sayeh.mp3");
            //InputStream is = new FileInputStream(file);
            // Get the size of the file
            long length = file.length();
            if (length > Integer.MAX_VALUE) {
                System.out.println("File is too large.");
            }
            byte[] bytes = new byte[(int) length];

            //out.write(bytes);
            System.out.println(bytes);

            out.close();
            in.close();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setSong(Song song){
        this.song = song;
    }
}
