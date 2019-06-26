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

        File file = new File("C:\\Users\\Mahdi\\Desktop\\bollywood_groove-kevin_macleod.mp3");
        String name=file.getName();
        String n=  name.substring(name.lastIndexOf(".") + 1);

        try {
            OutputStream os = client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(n);
            os.flush();


            FileInputStream fis = new FileInputStream(file);
            //BufferedInputStream bis = new BufferedInputStream(fis);
            int lenght = (int) file.length();
            byte[] myByteArray = new byte[1024];
            //bis.read(myByteArray, 0, 1024);
            os = client.getOutputStream();
            os.write(myByteArray, 0, 1024);
            os.flush();


            int packetSize = 1024;
            double nosofpackets=Math.ceil(((int) file.length())/packetSize);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            for(double i=0;i<nosofpackets+1;i++) {
                byte[] mybytearray = new byte[packetSize];
                bis.read(mybytearray, 0, mybytearray.length);
                System.out.println("Packet:"+(i+1));
                os = client.getOutputStream();
                os.write(mybytearray, 0,mybytearray.length);
                os.flush();
            }
        }

        catch (Exception ex) {
            System.out.println(ex);
        }
    }



}
