package logic.Controller.libraryControlller;


import graphic.MainFrame;
import graphic.center.MainPanel;
import graphic.variouspart.singlesong.SingleSongPanel;
import logic.Album;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;


public class SongsShowController {


    private static final String FILE_PATH = "D:\\avi.bin";
    protected ArrayList<Song> songs = null;

    public SongsShowController() {

        songs = new ArrayList<>();

        songs = readObjecFromFile(FILE_PATH , songs);

    }


    public SongsShowController(MainPanel view , Album album) {
        System.out.println("salam1");
        view.removeAll();
        view.setLayout(new BoxLayout(view , BoxLayout.Y_AXIS));
        System.out.println("salam2");
        songs = album.getAlbumSongs();
        System.out.println("salam3");
        for (Song song: songs) {
            SingleSongPanel singleSongPanel = new SingleSongPanel(song.getArtistName() , song.getAlbumName() , song.getTitle() , getImageFromByte(song.getArtWork()) , song , album);
            view.add(singleSongPanel);
        }
        System.out.println("salam4");
        view.repaint();
        view.validate();
        view.setVisible(true);
    }


    public SongsShowController(MainPanel view , PlayList playList) {
        view.removeAll();
        view.setLayout(new BoxLayout(view , BoxLayout.Y_AXIS));

        songs = playList.getSongsOfPlayList();

        for (Song song: songs) {
            SingleSongPanel singleSongPanel = new SingleSongPanel(song.getArtistName() , song.getAlbumName() , song.getTitle() , getImageFromByte(song.getArtWork()) , song , playList);
            view.add(singleSongPanel);
        }

        view.repaint();
        view.validate();
        view.setVisible(true);
    }


    public SongsShowController(MainPanel view) {
        view.removeAll();
        view.setLayout(new BoxLayout(view , BoxLayout.Y_AXIS));

        songs = new ArrayList<>();

        songs = readObjecFromFile(FILE_PATH , songs);

        for (Song song: songs) {
            SingleSongPanel singleSongPanel = new SingleSongPanel(song.getArtistName() , song.getAlbumName() , song.getTitle() , getImageFromByte(song.getArtWork()) , song);
            view.add(singleSongPanel);
        }

        view.repaint();
        view.validate();
        view.setVisible(true);
    }


    public ArrayList<Song> readObjecFromFile(String path , ArrayList<Song> songs) {

            try {
                FileInputStream fileIn = new FileInputStream(FILE_PATH);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                try {
                    while (true) {
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



    public Image getImageFromByte(byte[] imageBytes){
        byte[] byteArray = imageBytes;
        ImageIcon imageIcon = new ImageIcon(byteArray);
        Image image = imageIcon.getImage();
        return image;
    }


}
