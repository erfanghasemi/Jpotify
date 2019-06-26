package logic.Controller.libraryControlller;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.PlayList;
import logic.Song;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class SortPlayListSongController {




    public SortPlayListSongController(MainFrame myFrame , MainPanel view , PlayList playList , String titleFirstSong , String titleSecondSong) {

        ArrayList<PlayList> playLists = new ArrayList<>();

        PlayList targetPlayList;

        readObjecFromFile("D:\\kia.bin" , playLists);

        targetPlayList = findPlayList(playList,playLists);

        Collections.swap(targetPlayList.getSongsOfPlayList() , findIndexOfSong(titleFirstSong, targetPlayList.getSongsOfPlayList()) , findIndexOfSong(titleSecondSong , targetPlayList.getSongsOfPlayList()));

        try {
            FileOutputStream fileOut = new FileOutputStream("D:\\kia.bin");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (PlayList playList1: playLists) {
                objectOut.writeObject(playList1);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }


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

    public PlayList findPlayList(PlayList playList ,ArrayList<PlayList> playLists){

        for (PlayList playList1:playLists) {
            if(playList.getTitle().equals(playList1.getTitle())){
                return  playList1;
            }
        }
        return null;
    }

    public int findIndexOfSong(String titleSong , ArrayList<Song>songs){
        int index = 0;

        for (Song song:songs) {
            if(titleSong.equals(song.getTitle())){
                return index;
            }
            index++;
        }
        return 0;
    }










}
