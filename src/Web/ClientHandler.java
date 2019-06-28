package Web;

import logic.PlayList;
import logic.Song;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private Socket client;
    private String UserName;
    private volatile PlayList sharePlayList;

    public ClientHandler(Socket client) {
        this.client = client;
        // sharePlayList must be handled
    }

    public synchronized void setSharePlayList(PlayList sharePlayList) {
        this.sharePlayList = sharePlayList;
    }

    @Override
    public void run() {

        try {

            /// sending userName

            OutputStream os = client.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
            objectOutputStream.writeObject(UserName);
            os.flush();

            ///

            /// sending request

            InputStream inputStream = client.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            while (true){

                String request = (String) objectInputStream.readObject();

                ///

                switch (request){
                    case ("SharePlayList"):
                        objectOutputStream.writeObject(sharePlayList);
                        os.flush();


                    case ("GetSong"):
                        Song song = (Song) objectInputStream.readObject();

                        //// sending a song

                        File file = new File(song.getAddress());


                        String name = file.getName();
                        String n = name.substring(name.lastIndexOf(".") + 1);



                        DataOutputStream dos = new DataOutputStream(os);
                        dos.writeUTF(n);
                        os.flush();

                        long length = file.length();
                        System.out.println("client file length is:" + length);


                        dos.writeLong(length);
                        os.flush();

                        int packetSize = 16384;
                        double nosofpackets = Math.ceil(length / packetSize);
                        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
                        for (double i = 0; i < nosofpackets + 1; i++) {
                            byte[] mybytearray = new byte[packetSize];
                            bis.read(mybytearray, 0, mybytearray.length);
                            os = client.getOutputStream();
                            DataOutputStream dataOutputStream = new DataOutputStream(os);
                            dataOutputStream.write(mybytearray, 0, mybytearray.length);
                            os.flush();
                        }

                        System.out.println("complete ||||||||||");

                        ////
                }
            }



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setUserName(String userName) {
        UserName = userName;
    }
}
