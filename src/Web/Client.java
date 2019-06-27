package Web;

import logic.Song;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Client implements Runnable {

    private HashMap<String , String> Requests = new HashMap<>();
    private ArrayList<String> IPs = new ArrayList<>();
    private Song song;
//    private Boolean addIP = false;


    public Client () throws IOException, ClassNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Mahdi\\Desktop\\IPLists.doc");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        this.IPs = (ArrayList<String>) objectInputStream.readObject();
    }

    public void addIP (String IP) throws IOException {
        Requests.put(IP, "");
        IPs.add(IP);
//        addIP = true;
//        File file = new File("C:\\Users\\Mahdi\\Desktop\\IPLists.doc");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(IPs);
    }


    @Override
    public void run() {

        while (true) {
//            if (addIP) {
                for (String IP : IPs) {
                    try {

                        Socket client = new Socket(IP, 1385);
                        ServerHandler serverHandler = new ServerHandler(client, Requests.get(IP));
                        serverHandler.setSong(this.song);
                        Thread thread = new Thread(serverHandler);
                        thread.start();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


        }
    }

    public void setRequest(String IP, String request){
        Requests.replace(IP, request);
    }

    public void setSong(Song song) {
        this.song = song;
    }
}
