package logic.Controller.libraryControlller;

import graphic.center.MainPanel;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import static logic.Controller.libraryControlller.SubmitNewPlayListController.refreshPlayListTitleBar;

public class DeletePlayListController {


    private  ArrayList<PlayList> playLists = null;
    private static final String FILE_PATH_PLAYLIST  = "D:\\kia.bin";

    public DeletePlayListController(PlayList playList , MainPanel view) {

        playLists = new ArrayList<>();

        readObjecFromFile(FILE_PATH_PLAYLIST , playLists);

        removePlayList(playList , playLists);

        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH_PLAYLIST);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (PlayList playList1 : playLists) {
                objectOut.writeObject(playList1);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        new PlayListController(view);
    }





    public void removePlayList(PlayList targetPlayList , ArrayList<PlayList> playLists){
        int removeIndex = 0;
        for ( PlayList playList: playLists) {
            if(playList.getTitle().equals(targetPlayList.getTitle())){
                break;
            }
            removeIndex++;
        }
        playLists.remove(playLists.get(removeIndex));
    }



    public ArrayList<PlayList> readObjecFromFile(String path , ArrayList<PlayList> playLists) {

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (1 == 1) {
                    PlayList playList= (PlayList) objectIn.readObject();
                    playLists.add(playList);
                }
            }
            catch(EOFException e){
                return playLists;
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return playLists;
    }


}
