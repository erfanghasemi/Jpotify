package MusicHandler;

import logic.PlayList;
import logic.Song;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class FavouriteListener implements ActionListener {

    private static final String FILE_PATH_PLAYLIST = "D:\\kia.bin";
    private static final String FILE_PATH = "D:\\avi.bin";

    private ArrayList<PlayList> playLists;
    private ArrayList<Song> songs;
    private Song addedSong;

    public FavouriteListener(Song song) {

        addedSong = song;
        playLists = new ArrayList<>();
        songs = new ArrayList<>();

    }

    @Override
    public void actionPerformed(ActionEvent event) {

        PlayList favouritePlayList = null;
        Song favouriteSong = null;

        readObjecFromFile(FILE_PATH_PLAYLIST , playLists);
        favouritePlayList = findFavourite(playLists);

        songs = readSongFromFile(FILE_PATH , songs);
        favouriteSong = searchSong(songs , addedSong.getTitle());


        favouritePlayList.getSongsOfPlayList().add(favouriteSong);

        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH_PLAYLIST);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (PlayList playList1 : playLists) {
                objectOut.writeObject(playList1);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    public ArrayList<PlayList> readObjecFromFile(String path , ArrayList<PlayList> playLists) {

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
                return playLists;
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return playLists;
    }



    public PlayList findFavourite(ArrayList<PlayList> playLists){
        for ( PlayList playList : playLists) {
            if(playList.getTitle().equals("Favourite")){
                return playList;
            }
        }
        return null;
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

}
