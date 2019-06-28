package logic.Controller.libraryControlller;


import graphic.MainFrame;
import graphic.center.MainPanel;
import graphic.variouspart.SortPlayListSong;
import graphic.variouspart.singlesong.SingleSongPanel;
import logic.Album;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;


public class SongsShowController {


    private static final String FILE_PATH = "D:\\avi.bin";
    protected ArrayList<Song> songs = null;



    public SongsShowController(MainFrame myFrame , MainPanel view , Album album) {

        myFrame.remove(myFrame.getCenter());
        myFrame.remove(myFrame.getScrollPane());
        MainPanel newCenterPanel = new MainPanel();
        myFrame.setCenter(newCenterPanel);

        songs = album.getAlbumSongs();

        for (Song song: songs) {
            SingleSongPanel singleSongPanel = new SingleSongPanel(song.getArtistName() , song.getAlbumName() , song.getTitle() , getImageFromByte(song.getArtWork()) , song , album);
            newCenterPanel.add(singleSongPanel);
        }



        JScrollPane scrollPane = new JScrollPane(newCenterPanel );

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        myFrame.setScrollPane(scrollPane);

        scrollPane.repaint();
        scrollPane.validate();

        myFrame.repaint();
        myFrame.validate();
    }




    public SongsShowController( MainFrame myFrame, MainPanel view , PlayList playList) {
        myFrame.remove(myFrame.getCenter());
        myFrame.remove(myFrame.getScrollPane());
        MainPanel newCenterPanel = new MainPanel();
        myFrame.setCenter(newCenterPanel);

        songs = playList.getSongsOfPlayList();

        for (Song song: songs) {
            SingleSongPanel singleSongPanel = new SingleSongPanel(song.getArtistName() , song.getAlbumName() , song.getTitle() , getImageFromByte(song.getArtWork()) , song , playList);
            newCenterPanel.add(singleSongPanel);
        }

        newCenterPanel.add(new SortPlayListSong(playList));


        JScrollPane scrollPane = new JScrollPane(newCenterPanel );

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        myFrame.setScrollPane(scrollPane);

        scrollPane.repaint();
        scrollPane.validate();

        myFrame.repaint();
        myFrame.validate();
    }

    public SongsShowController( MainFrame myFrame, MainPanel view , String IP , PlayList sharePlayList) {
        myFrame.remove(myFrame.getCenter());
        myFrame.remove(myFrame.getScrollPane());
        MainPanel newCenterPanel = new MainPanel();
        myFrame.setCenter(newCenterPanel);

        for (Song song: sharePlayList.getSongsOfPlayList()) {
            SingleSongPanel singleSongPanel = new SingleSongPanel(song.getArtistName() , song.getAlbumName() , song.getTitle() , getImageFromByte(song.getArtWork()) , song , IP);
            newCenterPanel.add(singleSongPanel);
        }

        newCenterPanel.add(new SortPlayListSong(sharePlayList));


        JScrollPane scrollPane = new JScrollPane(newCenterPanel );

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        myFrame.setScrollPane(scrollPane);

        scrollPane.repaint();
        scrollPane.validate();

        myFrame.repaint();
        myFrame.validate();
    }




    public SongsShowController(MainFrame myFrame , MainPanel view) {
        myFrame.remove(myFrame.getCenter());
        myFrame.remove(myFrame.getScrollPane());
        MainPanel newCenterPanel = new MainPanel();
        myFrame.setCenter(newCenterPanel);

        songs = new ArrayList<>();

        songs = readObjecFromFile(FILE_PATH , songs);

        for (Song song: songs) {
            SingleSongPanel singleSongPanel = new SingleSongPanel(song.getArtistName() , song.getAlbumName() , song.getTitle() , getImageFromByte(song.getArtWork()) , song);
            newCenterPanel.add(singleSongPanel);
        }

        JScrollPane scrollPane = new JScrollPane(newCenterPanel );

        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        myFrame.setScrollPane(scrollPane);

        scrollPane.repaint();
        scrollPane.validate();

        myFrame.repaint();
        myFrame.validate();
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
