package Web;

import logic.Song;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Client implements Runnable {

    private ArrayList<String> recentIPs = new ArrayList<>();
    private ArrayList<String> laterIPs = new ArrayList<>();
    private HashMap<String, ServerHandler> ClientIP = new HashMap<>();
    private Song song;

    public void setSong(Song song) {
        this.song = song;
    }

    public Client() throws IOException, ClassNotFoundException {
//        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Mahdi\\Desktop\\IPLists.doc");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        this.IPs = (ArrayList<String>) objectInputStream.readObject();
    }

    public void addIP(String IP) throws IOException {
            recentIPs.add(IP);
            executor(IP);
//        File file = new File("C:\\Users\\Mahdi\\Desktop\\IPLists.doc");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(IPs);
    }


    @Override
    public void run() {

        do {
            //while (true){

            //if (addIP){
            for (String IP : laterIPs) {

                    try {

                        executor(IP);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    //      }
                    //}
            }

        }
        while (false);
    }

    public void setRequest(String IP, String request) {
        ClientIP.get(IP).setRequest(request);
    }

    public void executor(String IP) throws IOException {
        Socket client = new Socket(IP, 1385);
        ServerHandler serverHandler = new ServerHandler(client);
        ClientIP.put(IP, serverHandler);
        serverHandler.setSong(this.song);
        Thread thread = new Thread(serverHandler);
        thread.start();
    }
}
