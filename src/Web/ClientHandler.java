package Web;

import logic.PlayList;
import logic.Song;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    private Socket client;
    private String UserName;
    private volatile PlayList sharePlayList;

    public ClientHandler(Socket client) {
        this.client = client;
    }



    @Override
    public void run() {

        try {

            /// sending userName

            OutputStream os = client.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);


            ///

            /// sending request

            InputStream inputStream = client.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

            while (true){


                // the client sends us a request continuously
                // in the flowing line we receive that request continuously as well

                String request = (String) objectInputStream.readObject();

                /// in the flowing switch case we will respond to that request

                switch (request){
                    case ("SharePlayList"):

                        // sending my share playList to the client

                        sharePlayList = findSharePlayList();

                        objectOutputStream.writeObject(sharePlayList);
                        os.flush();
                        break;

                    case ("GetUserName"):

                        // sending my userName to the client

                        String nameOfUser = readObjecFromFile();
                        setUserName(nameOfUser);
                        objectOutputStream.writeObject(UserName);
                        os.flush();
                        break;

                    case ("GetSong"):

                        // we are receiving the song that client wants to download it

                        Song song = (Song) objectInputStream.readObject();

                        //// sending the song's file

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

                        int packetSize = 256;
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

                        //// the file has been completely sent to the client
                }
            }



        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    // this method finds our share playList and sets it

    /**
     *
     * @return this is my sharePlayList
     * this method searches int the playLists for the sharePlayList and returns it
     */


    public PlayList findSharePlayList(){
        ArrayList<PlayList> playLists = new ArrayList<>();
        playLists = readPlayListFromFile("D:\\Kia.bin" , playLists);

        for (PlayList playList: playLists) {
            if (playList.getTitle().equals("Share")){
                return playList;
            }
        }
        return null;
    }

    /**
     *
     * @param path this is a file's path that we have saved our PlayLists in it
     * @param playLists
     * @return
     */

    public ArrayList<PlayList> readPlayListFromFile(String path, ArrayList<PlayList> playLists) {

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (true) {
                    PlayList playList = (PlayList) objectIn.readObject();
                    playLists.add(playList);
                }
            } catch (EOFException e) {
                return playLists;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return playLists;
    }

//

    /**
     *
     * @return this is my userName
     * this method reads my userName from a file
     */

    public String readObjecFromFile() {

        String userName = null;

        try {
            FileInputStream fileIn = new FileInputStream("D:\\olk.bin");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            userName = (String) objectIn.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return userName;
    }


}
