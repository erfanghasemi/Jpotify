package logic.Controller.libraryControlller;

import graphic.MainFrame;
import logic.Song;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SignInController {

    private static final String LOGIN_FILE_PATH = "D:\\olk.bin";
    String userName;

    public SignInController(MainFrame mainFrame) {
            userName = readObjecFromFile(LOGIN_FILE_PATH);
            mainFrame.setUserName(userName);
    }



    public String readObjecFromFile(String path) {

        String userName = null;

        try {
            FileInputStream fileIn = new FileInputStream(LOGIN_FILE_PATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            userName = (String) objectIn.readObject();
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return userName;
    }
}
