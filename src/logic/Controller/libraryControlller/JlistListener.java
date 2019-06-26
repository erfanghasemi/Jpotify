package logic.Controller.libraryControlller;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.PlayList;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class JlistListener  {

    public JlistListener(MainFrame myFrame, MainPanel view , String title) {

        PlayList targetPlayList = null;


        ArrayList<PlayList> playLists = new ArrayList<>();

        readObjecFromFile("D:\\kia.bin" , playLists);

        targetPlayList = findPlayList(title , playLists);

        new SongsShowController(myFrame , view , targetPlayList);
    }



    public void readObjecFromFile(String path , ArrayList<PlayList> playLists) {

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (true) {
                    PlayList playList = (PlayList) objectIn.readObject();
                    playLists.add(playList);
                }
            }
            catch(EOFException e){
                return ;
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }


    public PlayList findPlayList(String title ,ArrayList<PlayList> playLists){

        for (PlayList playList1:playLists) {
            if(title.equals(playList1.getTitle())){
                return  playList1;
            }
        }
        return null;
    }





}
