package logic.Controller.libraryControlller;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Controller.libraryControlller.SongsShowController;
import logic.PlayList;
import logic.Song;

import java.io.*;
import java.util.ArrayList;

import static logic.Controller.libraryControlller.SubmitNewPlayListController.refreshPlayListTitleBar;

public class DeleteSongPlayListController {

    private static final String FILE_PATH_PLAYLIST = "D:\\kia.bin";
    ArrayList<PlayList> playLists;

    public DeleteSongPlayListController(MainFrame myFarme , MainPanel view , PlayList playList , Song song) {

        playLists = new ArrayList<>();
        PlayList targetPlayList = null;
        int indexOfSong;

        readPlayListFromFile(FILE_PATH_PLAYLIST , playLists);

        targetPlayList = searchPLayList(playLists , playList);
        indexOfSong = findIndexOfSong(targetPlayList , song);

        targetPlayList.getSongsOfPlayList().remove(indexOfSong);

        if(targetPlayList.getSongsOfPlayList().size() == 0){
            playLists.remove(targetPlayList);
        }


        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH_PLAYLIST);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (PlayList playList1: playLists) {

                objectOut.writeObject(playList1);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }


        playList.getSongsOfPlayList().remove(song);
        refreshPlayListTitleBar("D:\\kia.bin" , myFarme.getWest().getPlaylistPanel().getPlayLists());
        new SongsShowController(myFarme , view , playList);
    }


    public ArrayList<PlayList> readPlayListFromFile(String path, ArrayList<PlayList> playLists) {

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (true) {
                    PlayList playList = (PlayList) objectIn.readObject();
                    playLists.add(playList);
                }
            } catch (EOFException e) {
                return playLists;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return playLists;
    }



    public PlayList searchPLayList(ArrayList<PlayList> playLists , PlayList playList){
        PlayList targetPlayList = null;
        for (PlayList playList1:playLists) {
            if(playList1.getTitle().equals(playList.getTitle())){
                targetPlayList = playList1;
            }
        }
        return targetPlayList;
    }

    public int findIndexOfSong(PlayList playList , Song song){
        int counter = 0;
        for (Song song1 : playList.getSongsOfPlayList()) {
            if(song1.getTitle().equals(song.getTitle())){
                return counter;

            }
            counter++;
        }
        return 0;
    }



}
