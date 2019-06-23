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


    public boolean equals(Album other){
        boolean result;
        if((other == null) || (getClass() != other.getClass())){
            result = false;
        }
        else{
            Album otherAlbum = (Album)other;
            result = artistName.equals(other.artistName) &&  title.equals(other.title);
        }

        return result;
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
