package Web;

import java.io.*;

public class IPList {

    public IPList(String IP) throws IOException {

        File file = new File("C:\\Users\\Mahdi\\Desktop\\IPLists.doc");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(IP);

    }
}
