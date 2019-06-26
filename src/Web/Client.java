package Web;

import logic.PlayList;
import logic.Song;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Client implements Runnable {

    private Socket client;
    private Song song;
    private String useName;

    public Client(String ip, int port) throws IOException {
        this.client = new Socket(ip, port);
    }

    public void run() {


        File file = new File(song.getAddress());


        String name = file.getName();
        String n = name.substring(name.lastIndexOf(".") + 1);


        try {
            OutputStream os = client.getOutputStream();

            FileInputStream fileInputStream = new FileInputStream("D:\\olk.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            useName = (String) objectInputStream.readObject();
            fileInputStream.close();


            ObjectOutputStream objectOutputStream = new ObjectOutputStream(os);
            objectOutputStream.writeObject(useName);
            os.flush();

            ArrayList<PlayList> playLists = new ArrayList<>();
            readObjecFromFile("D:\\kia.bin", playLists);
            PlayList playList = findSharePlaylist(playLists);

            objectOutputStream = new ObjectOutputStream(os);
            objectOutputStream.writeObject(playList);
            os.flush();


            DataOutputStream dos = new DataOutputStream(os);
            dos.writeUTF(n);
            os.flush();

            long length = file.length();
            System.out.println("client file length is:" + length);
            //String s = length.toString();

            dos.writeLong(length);
            os.flush();

            while (true){
                InputStream inputStream = client.getInputStream();
                objectInputStream = new ObjectInputStream(inputStream);
                String request = (String) objectInputStream.readObject();
                if (!request.equals(""))
                    break;
            }


            int packetSize = 1024;
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
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void setSong(Song song) {
        this.song = song;
    }


    public void readObjecFromFile(String path, ArrayList<PlayList> playLists) {

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (true) {
                    PlayList playList = (PlayList) objectIn.readObject();
                    playLists.add(playList);
                }
            } catch (EOFException e) {
                return;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public PlayList findSharePlaylist(ArrayList<PlayList> playLists) {
        for (PlayList playList : playLists) {

            if (playList.getTitle().equals("Share"))
                return playList;

        }

        return null;
    }


}
