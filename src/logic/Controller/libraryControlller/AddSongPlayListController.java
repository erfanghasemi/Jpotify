package logic.Controller.libraryControlller;

import graphic.MainFrame;
import graphic.center.MainPanel;
import graphic.variouspart.additem.AddSongPanel;
import logic.PlayList;
import logic.Song;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class AddSongPlayListController implements ActionListener {

    AddSongPanel addSongPanel;
    private ArrayList<Song> songs;
    private ArrayList<PlayList> playLists;
    private PlayList playList;
    private MainPanel view;
    private MainFrame myFrame;

    private static final String FILE_PATH = "D:\\avi.bin";
    private static final String FILE_PATH_PLAYLIST = "D:\\kia.bin";


    public AddSongPlayListController(MainPanel view , PlayList playList , MainFrame myFrame) {

        addSongPanel = new AddSongPanel(this, "Please Enter Your Song Title: " , view);

        this.playList = playList;
        this.view = view;
        this.myFrame = myFrame;

        songs = new ArrayList<>();
        playLists = new ArrayList<>();


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        Song addedSong = null;
        PlayList addedPlayList = null;

        readPlayListFromFile(FILE_PATH_PLAYLIST, playLists);
        readSongFromFile(FILE_PATH, songs);

        addedSong = searchSong(songs , addSongPanel.getJTextFieldText());
        addedPlayList = searchPLayList(playLists , playList);


        addedPlayList.getSongsOfPlayList().add(addedSong);


        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH_PLAYLIST);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (PlayList playList: playLists) {
                objectOut.writeObject(playList);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        new PlayListController(myFrame , view);

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


    public ArrayList<Song> readSongFromFile(String path, ArrayList<Song> songs) {

        try {
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (true) {
                    Song song = (Song) objectIn.readObject();
                    songs.add(song);
                }
            } catch (EOFException e) {
                return songs;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return songs;
    }

    public Song searchSong(ArrayList<Song> songs , String title){
        Song targetSong = null;
        for (Song song:songs) {
            if(song.getTitle().equals(title)){
                targetSong = song;
            }
        }
        return targetSong;
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

}