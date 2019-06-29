package Web;

import graphic.MainFrame;
import logic.Song;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;



public class Client {

    private HashMap<String, ServerHandler> ClientIP;
    private MainFrame mainFrame;


    public Client(MainFrame mainFrame) throws IOException, ClassNotFoundException {

        ClientIP = new HashMap<>();
        this.mainFrame = mainFrame;

    }


    /**
     *
     * @param IP this is the address of the system that we want to send a request to
     * @param request here we set the request we want
     *                this method initializes the request we send for a special server
     */

    public void setRequest(String IP, String request) {
        ClientIP.get(IP).setRequest(request);
    }

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
