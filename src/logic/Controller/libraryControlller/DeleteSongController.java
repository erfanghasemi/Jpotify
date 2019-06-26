package logic.Controller.libraryControlller;

import graphic.MainFrame;
import graphic.center.MainPanel;
import logic.Album;
import logic.Song;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class DeleteSongController {

    private ArrayList<Song> songs = null;
    private static final String FILE_PATH = "D:\\avi.bin";

    public DeleteSongController(Song song , MainPanel view , MainFrame myFrame) {

        songs = new ArrayList<>();

        readObjecFromFile(FILE_PATH , songs);

        removeSong(song , songs);

            try {
                FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                for (Song music: songs) {
                    objectOut.writeObject(music);
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        new SongsShowController(myFrame ,view);
    }

    public DeleteSongController(Song song , Album album , MainPanel view , MainFrame myframe) {

        songs = new ArrayList<>();

        readObjecFromFile(FILE_PATH , songs);

        removeSong(song , songs);
        album.getAlbumSongs().remove(song);

        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Song music: songs) {
                objectOut.writeObject(music);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        new SongsShowController(myframe,view,album);
    }


    public void removeSong(Song targetSong , ArrayList<Song> songs){
        int removeIndex = 0;
        for ( Song song: songs) {
            if(song.getTitle().equals(targetSong.getTitle())){
                break;
            }
            removeIndex++;
        }
        songs.remove(songs.get(removeIndex));
    }

    public ArrayList<Song> readObjecFromFile(String path , ArrayList<Song> songs) {

        try {
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (1 == 1) {
                    Song song = (Song) objectIn.readObject();
                    songs.add(song);
                }
            }
            catch(EOFException e){
                return songs;
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return songs;
    }

}
