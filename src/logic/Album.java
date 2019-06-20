package logic;

import java.awt.*;
import java.util.ArrayList;

public class Album {

    private String address;
    private Image artWork;
    private String artistName;
    private String albumName;
    private String musicName;

    private ArrayList<Song> albumSongs;

    public Album(String address, Image artWork, String artistName, String albumName, String musicName, ArrayList<Song> albumSongs) {
        this.address = address;
        this.artWork = artWork;
        this.artistName = artistName;
        this.albumName = albumName;
        this.musicName = musicName;
        this.albumSongs = albumSongs;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public ArrayList<Song> getAlbumSongs() {
        return albumSongs;
    }

    public void setAlbumSongs(ArrayList<Song> albumSongs) {
        this.albumSongs = albumSongs;
    }
}
