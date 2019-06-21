package logic;

import java.awt.*;
import java.util.ArrayList;

public class Album {

    private Image artWork;
    private String artistName;
    private String title;

    private ArrayList<Song> albumSongs;

    public Album(String albumName) {
        this.title = albumName;
        albumSongs = new ArrayList<>();
    }

    public Image getArtWork() {
        return artWork;
    }

    public void setArtWork(Image artWork) {
        this.artWork = artWork;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Song> getAlbumSongs() {
        return albumSongs;
    }

}
