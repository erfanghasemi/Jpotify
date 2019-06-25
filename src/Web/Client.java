package Web;

import logic.Song;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable {

    Socket client;

    public Client (String port, int ip) throws IOException {
        client = new Socket(port, ip);
    }

    public void run (){
        try {
            OutputStream outputStream  = client.getOutputStream();
            Song song = new Song("D:\\Music\\Moein - Donyaye Eshgh\\02 Sayeh.mp3");
            FileInputStream fileInputStream = new FileInputStream(song.getAddress());
            int i;
            while ((i = fileInputStream.read()) != -1){
                byte b = (byte) i;
                outputStream.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
