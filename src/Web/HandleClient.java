package Web;

import logic.Friend;
import logic.PlayList;

import java.io.*;
import java.net.Socket;

public class HandleClient implements Runnable{

    private Socket client;
    private final static String FRIEND_FILE_PATH = "D:\\friend.bin";

    public HandleClient(Socket client){
        this.client = client;
    }

    public void run(){


        String folder = "C:\\Users\\Mahdi\\Desktop\\New folder (2)";
        DataInputStream dis;
        try {
            InputStream inputStream = client.getInputStream();

            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            String userName = (String) objectInputStream.readObject();

            PlayList playList = (PlayList) objectInputStream.readObject();

            Friend friend = new Friend(userName, playList);

            writeObjectToFile(friend);








            dis = new DataInputStream(inputStream);
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
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void writeObjectToFile(Friend friend) {
        if(true){
            try {
                if((new File(FRIEND_FILE_PATH).exists())) {
                    FileOutputStream fileOut = new FileOutputStream(FRIEND_FILE_PATH, true);
                    AppendingObjectOutputStream objectOut = new AppendingObjectOutputStream(fileOut);
                    objectOut.writeObject(friend);
                }
                else{
                    FileOutputStream fileOut = new FileOutputStream(FRIEND_FILE_PATH, true);
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(friend);
                }



            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }



    public class AppendingObjectOutputStream extends ObjectOutputStream {

        public AppendingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // do not write a header, but reset:
            // this line added after another question
            // showed a problem with the original
            reset();
        }

    }


}
