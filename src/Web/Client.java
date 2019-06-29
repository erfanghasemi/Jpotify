package Web;

import graphic.MainFrame;
import logic.Song;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;



public class Client implements Runnable {

//    private volatile ArrayList<String> recentIPs;
//    private ArrayList<String> laterIPs;
    private HashMap<String, ServerHandler> ClientIP;
    private MainFrame mainFrame;
    //private Song song;

    public Client(MainFrame mainFrame) throws IOException, ClassNotFoundException {
//
//        recentIPs = new ArrayList<>();
//        laterIPs = new ArrayList<>();
        ClientIP = new HashMap<>();
        this.mainFrame = mainFrame;


//        if(new File("D:\\friend.bin").exists()) {
//            readIPFromFile(laterIPs);
//        }
    }

    public synchronized void addIP(String IP) throws IOException {
//        recentIPs.add(IP);
//        executor(IP);
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

    // this method sends the given request for the given IP server

    /**
     *
     * @param IP this is the address of the system that we want to send a request to
     * @param request here we set the request we want
     *                this method initializes the request we send for a special server
     */

    public void setRequest(String IP, String request) {
        ClientIP.get(IP).setRequest(request);
    }

    // this is a hand made thread pool (executor service)
    // this will provides a connection to the given IP and and run it in a new thread

    /**
     *
     * @param IP this is the IP of the system we want to make a contact with
     * @throws IOException
     * this method is a hand made executorService
     * this method connects our system to the server that we have given its IP
     * after the connection is made, the executor will run it in a separated thread
     */

    public void executor(String IP) throws IOException {
        Socket client = new Socket(IP, 1385);
        ServerHandler serverHandler = new ServerHandler(mainFrame , client);
        ClientIP.put(IP, serverHandler);
        //serverHandler.setSong(this.song);
        Thread thread = new Thread(serverHandler);
        thread.start();
    }

    /**
     *
     * @param song this is the song that we want to download it from another system
     * @param IP this is the IP of the system that we want to receive the song from
     * this method clarifies that which song we are looking for to download after the "GetSong" request is sent to the server
     *
     */

    // this method will send a song to receive its file from the given IP server

    public synchronized void setSong(Song song, String IP) {
        ClientIP.get(IP).setSong(song);
    }
//
//    public void readIPFromFile(ArrayList<String> IPs) {
//
//        try {
//            FileInputStream fileInputStream = new FileInputStream("D:\\friend.bin");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//
//            try {
//
//
//                while (true) {
//
//                    String IP = (String) objectInputStream.readObject();
//                    IPs.add(IP);
//                }
//
//
//            } catch (EOFException e) {
//                return;
//            }
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//    }


    public HashMap<String, ServerHandler> getClientIP() {
        return ClientIP;
    }

    /**
     *
     * @param IP this is the IP of the system that we want to make a connection to it
     * this method provides a connection to the given IP
     */

    public void connect(String IP) {
        try {
            executor(IP);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
