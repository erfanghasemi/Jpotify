package Web;

import logic.Song;

import java.io.*;
import java.net.Socket;

public class Client implements Runnable {

    private Socket client;
    private Song song;

    public Client(String ip, int port) throws IOException {
        this.client = new Socket(ip, port);
    }

    public void run(){

        File file = new File("D:\\Music\\Moein - Donyaye Eshgh\\02 Sayeh.mp3");
        String name=file.getName();
        String n=  name.substring(name.lastIndexOf(".") + 1);

        try {
            OutputStream os = client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(n);
            os.flush();

            long length = file.length();
            System.out.println("client file length is:" + length);
            //String s = length.toString();

            dos.writeLong(length);
            os.flush();


            int packetSize = 1024;
            double nosofpackets = Math.ceil(length / packetSize);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            for(double i=0;i<nosofpackets+1;i++) {
                byte[] mybytearray = new byte[packetSize];
                bis.read(mybytearray, 0, mybytearray.length);
                os = client.getOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(os);
                dataOutputStream.write(mybytearray, 0,mybytearray.length);
                os.flush();
            }
        }

        catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void setSong(Song song){
        this.song = song;
    }

}
