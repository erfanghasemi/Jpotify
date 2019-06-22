package logic.Controller.libraryControlller;

import graphic.center.MainPanel;
import graphic.variouspart.singlealbum.SingleAlbumPanel;
import logic.Album;
import logic.Song;

import javax.swing.*;
import java.util.ArrayList;

public class AlbumsController extends SongsShowController {

    protected ArrayList<Album> albums;
    private static final String FILE_PATH = "D:\\avi.bin";

    public AlbumsController(MainPanel view) {
        super();
        view.removeAll();

        view.setLayout(new BoxLayout(view , BoxLayout.Y_AXIS));



        albums = new ArrayList<>();

        classifyAlbum(songs , albums);





        for (Album album : albums) {
            Song firstSong = album.getAlbumSongs().get(0);
            SingleAlbumPanel singleAlbumPanel = new SingleAlbumPanel(firstSong.getAlbumName() , firstSong.getArtistName() , getImageFromByte(firstSong.getArtWork()), album);
            view.add(singleAlbumPanel);
        }

        view.repaint();
        view.validate();
        view.setVisible(true);

    }


    public void classifyAlbum(ArrayList<Song> songs , ArrayList<Album> albums) {

        Boolean newSong = true;

        for (Song song : songs) {
            if (!(albums.isEmpty())) {
                for (Album album : albums) {
                    if (song.getAlbumName().equals(album.getTitle())) {
                        album.getAlbumSongs().add(song);
                        newSong = false;
                    }
                }
                if(newSong){
                        Album newAlbum = new Album(song.getAlbumName());
                        newAlbum.getAlbumSongs().add(song);
                        albums.add(newAlbum);
                }
                newSong = true;
            }
            else{
                Album newAlbum = new Album(song.getAlbumName());
                newAlbum.getAlbumSongs().add(song);
                albums.add(newAlbum);

            }
        }
    }


}
