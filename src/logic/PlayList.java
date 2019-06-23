package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class PlayList implements Serializable {

    private String title;

    ArrayList<Song> songsOfPlayList;

    public PlayList(String title) {
        this.title = title;
        songsOfPlayList = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Song> getSongsOfPlayList() {
        return songsOfPlayList;
    }

}
