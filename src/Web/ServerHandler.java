package Web;

import graphic.MainFrame;
import logic.Controller.libraryControlller.SaveFileController;
import logic.Controller.libraryControlller.SongsShowController;
import logic.Friend;
import logic.PlayList;
import logic.Song;

import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;

public class ServerHandler implements Runnable {

    private Socket server;
    private volatile String request = "";
    private String serverUserNmae;
    private PlayList sharePlayList;
    private volatile Song song;
    MainFrame mainFrame;
    // this must be changed in the other computer
    private final static String FOLDER = "D:\\";

    public synchronized void setRequest(String request) {
        this.request = request;
    }

    public ServerHandler(MainFrame mainFrame ,Socket client){

        this.server = client;
        this.mainFrame = mainFrame;

    }


    @Override
    public void run() {

        int j = 1;

        try {

            /// receive userName

            InputStream inputStream = server.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);


            ///
            OutputStream outputStream = server.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            while (true){


                objectOutputStream.writeObject(request);
                outputStream.flush();

                ///

                switch (request){
                    case ("SharePlayList"):
                        sharePlayList = (PlayList) objectInputStream.readObject();
                        setSharePlayList(sharePlayList);

                        String IP = null;

                        for ( String key :mainFrame.getClient().getClientIP().keySet()) {
                                if(this == mainFrame.getClient().getClientIP().get(key)){
                                    IP = key;
                                }
                        }

                        new SongsShowController(mainFrame ,mainFrame.getCenter() ,IP  ,sharePlayList );

                        break;


                    case ("GetUserName"):
                        serverUserNmae = (String) objectInputStream.readObject();

                        IP = null;

                        for ( String key :mainFrame.getClient().getClientIP().keySet()) {
                            if(this == mainFrame.getClient().getClientIP().get(key)){
                                IP = key;
                            }
                        }
                        Friend friend = new Friend(serverUserNmae , IP);


                        writeObjectToFile(friend);

                        break;

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


                        int packetsize = 256;
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
                        System.out.println("complete");
                        new SaveFileController(path);
                        //server.close();
                        bos.close();

                        ///////

                }

                request = "";
            }

            /// sending request

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public synchronized void setSong(Song song){
        this.song = song;
    }

    public PlayList getSharePlayList() {
        return sharePlayList;
    }

    public void setSharePlayList(PlayList sharePlayList) {
        this.sharePlayList = sharePlayList;
    }

    public void writeObjectToFile(Friend friend) {
        if(true){
            try {
                if((new File("D:\\friend.bin").exists())) {
                    FileOutputStream fileOut = new FileOutputStream("D:\\friend.bin", true);
                    AppendingObjectOutputStream objectOut = new AppendingObjectOutputStream(fileOut);
                    objectOut.writeObject(friend);
                }
                else{
                    FileOutputStream fileOut = new FileOutputStream("D:\\friend.bin", true);
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
