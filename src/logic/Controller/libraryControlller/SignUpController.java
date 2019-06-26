package logic.Controller.libraryControlller;


import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class SignUpController {


    private static final String LOGIN_FILE_PATH = "D:\\olk.bin";

    public SignUpController(String userName , MainPanel view ,MainFrame myFrame) {
        writeObjectToFile(userName);
        new SongsShowController( myFrame ,view);
    }

    public void writeObjectToFile(String string) {

        try {
            FileOutputStream fileOut = new FileOutputStream(LOGIN_FILE_PATH, true);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(string);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}