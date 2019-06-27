package Web;

import logic.PlayList;
import logic.Song;

import java.io.*;
import java.net.Socket;

public class ServerHandler implements Runnable {

    private Socket server;
    private String request;
    private String ServerUserNmae;
    private PlayList sharePlayList;
    private Song song;
    private final static String FOLDER = "C:\\Users\\01RAYANEH\\Desktop\\ReceivedSongs";

    public ServerHandler(Socket client, String request){

        this.server = client;
        this.request = request;

    }


    @Override
    public void run() {

        int j = 1;

        try {

            /// receive userName

            InputStream inputStream = server.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            ServerUserNmae = (String) objectInputStream.readObject();

            ///

            while (true){

                OutputStream outputStream = server.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(request);
                outputStream.flush();

                ///

                switch (request){
                    case ("SharePlayList"):
                        sharePlayList = (PlayList) objectInputStream.readObject();

                    case ("GetSong"):

                        objectOutputStream.writeObject(song);
                        outputStream.flush();


                        ////// receiving a song

                        DataInputStream dis = new DataInputStream(inputStream);
                        String ext = dis.readUTF();

                        long length = dis.readLong();
                        System.out.println("server file length is:" + length);

                        System.out.println(ext);

                        System.out.println("extension read");

                        String path = FOLDER + j + "." + ext;
                        j++;
                        File f = new File(path);
                        OutputStream output = new FileOutputStream(f);


                        int packetsize = 16384;
                        BufferedOutputStream bos = new BufferedOutputStream(output);
                        double nosofpackets = Math.ceil(length / packetsize);
                        for (double i = 0; i < nosofpackets + 1; i++) {
                            InputStream is = server.getInputStream();
                            byte[] mybytearray = new byte[packetsize];
                            int bytesRead = is.read(mybytearray, 0, mybytearray.length);


                            System.out.println("bytesRead:" + bytesRead);
                            System.out.println("Packet:" + (i + 1));
                            bos.write(mybytearray, 0, mybytearray.length);

                        }


                        System.out.println("Complete !!!");
                        server.close();
                        bos.close();

                        ///////

                }
            }

            /// sending request

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void setSong(Song song){
        this.song = song;
    }
}
