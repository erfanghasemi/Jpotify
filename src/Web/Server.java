package Web;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable{

    ServerSocket serverSocket;
    private ExecutorService executorService;

    public Server (int port) throws IOException {
        serverSocket = new ServerSocket(port);
        executorService = Executors.newCachedThreadPool();
    }

    public void run (){
        while (true){
            try
            {
                System.out.println("listening for client: ");
                Socket client = serverSocket.accept();

                System.out.println("connection from : " + client.getInetAddress().getHostAddress());

                executorService.submit(new HandleClient(client));

            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }

    }


}
