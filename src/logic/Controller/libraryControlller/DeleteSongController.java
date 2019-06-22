package logic.Controller.libraryControlller;

import graphic.center.MainPanel;
import logic.Song;

import java.io.*;
import java.util.ArrayList;

public class DeleteSongController {

    private ArrayList<Song> songs = null;
    private static final String FILE_PATH = "D:\\avi.bin";

    public DeleteSongController(Song song , MainPanel view) {

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

        new SongsShowController(view);
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
