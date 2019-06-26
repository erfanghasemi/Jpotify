package Web;

import java.io.*;
import java.net.Socket;

public class HandleClient implements Runnable{

    private Socket client;

    public HandleClient(Socket client){
        this.client = client;
    }

    public void run(){
        String folder = "C:\\Users\\Mahdi\\Desktop\\New folder (2)";
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(client.getInputStream());
            String ext  = dis.readUTF();

            long length = dis.readLong();
            System.out.println("server file length is:" + length);

            System.out.println(ext);

            System.out.println("extension read");



            String path = folder + "." + ext;
            File f= new File(path);
            OutputStream output = new FileOutputStream(f);


            int packetsize=1024;
            BufferedOutputStream bos = new BufferedOutputStream(output);
            double nosofpackets = Math.ceil(length / packetsize);
            for(double i = 0; i < nosofpackets + 1; i++)
            {
                InputStream is = client.getInputStream();
                byte[] mybytearray = new byte[packetsize];
                int bytesRead = is.read(mybytearray, 0,mybytearray.length );


                System.out.println("bytesRead:" + bytesRead);
                System.out.println("Packet:"+(i+1));
                bos.write(mybytearray, 0,mybytearray.length);

            }
            client.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
