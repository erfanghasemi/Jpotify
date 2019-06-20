package logic;

import java.awt.*;
import java.io.Serializable;

public class Song implements Serializable {

    private String address;
    private Image artWork;
    private String artistName;
    private String albumName;
    private String title;
    private long lengthOfSong;


    public Song(String address) {
        this.address = address;
    }

	public long getLengthOfSong() {
		return lengthOfSong;
	}

	public void setLengthOfSong(long lengthOfSong) {
		this.lengthOfSong = lengthOfSong;
	}

	public String getAddress() {
        return address;
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

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

}
