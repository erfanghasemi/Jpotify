package logic;

import java.io.Serializable;

public class
Song implements Serializable {

    private String address;
    private byte[] artWork;
    private String artistName;
    private String albumName;
    private String title;
    private long lengthOfSong;
    // this variable shows true if the song is playing
    private boolean isPlaying = false;
    private int frames;


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

    public byte[] getArtWork() {
        return artWork;
    }

    public void setArtWork(byte[] artWork) {
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

    public void setPlaying (boolean playing){
        this.isPlaying = playing;
    }

    public boolean getPlaying(){
        return this.isPlaying;
    }

    public void setFrames(int frames){
        this.frames = frames;
    }

    public int getFrames(){
        return frames;
    }

}
