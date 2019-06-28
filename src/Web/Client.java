package Web;

import logic.Song;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class Client implements Runnable {

    private volatile ArrayList<String> recentIPs;
    private ArrayList<String> laterIPs;
    private HashMap<String, ServerHandler> ClientIP;
    //private Song song;

    public Client() throws IOException, ClassNotFoundException {

        recentIPs = new ArrayList<>();
        laterIPs = new ArrayList<>();
        ClientIP = new HashMap<>();


        if(new File("D:\\friend.bin").exists()) {
            readIPFromFile(laterIPs);
        }
    }

    public synchronized void addIP(String IP) throws IOException {
        recentIPs.add(IP);
        executor(IP);
//        File file = new File("C:\\Users\\Mahdi\\Desktop\\IPLists.doc");
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
//        objectOutputStream.writeObject(IPs);
    }


    @Override
    public void run() {

//        do {
//            //while (true){
//
//            //if (addIP){
//            for (String IP : laterIPs) {
//
//                try {
//
//                    executor(IP);
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                //      }
//                //}
//            }
//
//        }
//        while (false);
    }

    public void setRequest(String IP, String request) {
        ClientIP.get(IP).setRequest(request);
    }

    public void executor(String IP) throws IOException {
        Socket client = new Socket(IP, 1385);
        ServerHandler serverHandler = new ServerHandler(client);
        ClientIP.put(IP, serverHandler);
        //serverHandler.setSong(this.song);
        Thread thread = new Thread(serverHandler);
        thread.start();
    }

    public synchronized void setSong(Song song, String IP) {
        ClientIP.get(IP).setSong(song);
    }

    public void readIPFromFile(ArrayList<String> IPs) {

        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\friend.bin");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            try {


                while (true) {

                    String IP = (String) objectInputStream.readObject();
                    IPs.add(IP);
                }


            } catch (EOFException e) {
                return;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    public HashMap<String, ServerHandler> getClientIP() {
        return ClientIP;
    }

    public void connect(String IP) {
        try {
            executor(IP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
