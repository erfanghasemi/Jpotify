package logic.Controller.libraryControlller;

import graphic.MainFrame;
import graphic.center.MainPanel;
import graphic.variouspart.singlealbum.SingleAlbumPanel;
import logic.Album;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class AlbumsController {

    protected ArrayList<Album> albums;
    private static final String FILE_PATH = "D:\\avi.bin";
    protected ArrayList<Song> songs;

    public AlbumsController(MainFrame myFrame , MainPanel view) {
        myFrame.remove(myFrame.getCenter());
        myFrame.remove(myFrame.getScrollPane());
        MainPanel newCenterPanel = new MainPanel();
        myFrame.setCenter(newCenterPanel);


        songs = new ArrayList<>();
        songs = readObjecFromFile(FILE_PATH , songs);


        albums = new ArrayList<>();

        classifyAlbum(songs , albums);

        for (Album album : albums) {
            Song firstSong = album.getAlbumSongs().get(0);
            SingleAlbumPanel singleAlbumPanel = new SingleAlbumPanel(firstSong.getAlbumName() , firstSong.getArtistName() , getImageFromByte(firstSong.getArtWork()), album);
            newCenterPanel.add(singleAlbumPanel);
        }



        JScrollPane scrollPane = new JScrollPane(newCenterPanel);

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        myFrame.setScrollPane(scrollPane);

        newCenterPanel.repaint();
        newCenterPanel.validate();
        scrollPane.repaint();
        scrollPane.validate();

        myFrame.repaint();
        myFrame.validate();
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
