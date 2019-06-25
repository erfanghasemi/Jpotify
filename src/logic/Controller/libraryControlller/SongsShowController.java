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
import java.util.ArrayList;


public class SongsShowController {


    private static final String FILE_PATH = "D:\\avi.bin";
    protected ArrayList<Song> songs = null;

    public SongsShowController() {

        songs = new ArrayList<>();
        songs = readObjecFromFile(FILE_PATH , songs);

    }


    public SongsShowController(MainFrame myFrame , MainPanel view , Album album) {

        view.removeAll();
        view.setLayout(new BoxLayout(view , BoxLayout.Y_AXIS));
        view.setBackground(Color.white);

        songs = album.getAlbumSongs();

        for (Song song: songs) {
            SingleSongPanel singleSongPanel = new SingleSongPanel(song.getArtistName() , song.getAlbumName() , song.getTitle() , getImageFromByte(song.getArtWork()) , song , album);
            view.add(singleSongPanel);
        }


        JScrollPane scrollPane = new JScrollPane(view);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        myFrame.add(scrollPane , BorderLayout.CENTER);

        scrollPane.repaint();
        scrollPane.validate();
        myFrame.repaint();
        myFrame.validate();
        scrollPane.setVisible(true);
    }


    public SongsShowController( MainFrame myFrame, MainPanel view , PlayList playList) {
        view.removeAll();
        view.setLayout(new BoxLayout(view , BoxLayout.Y_AXIS));
        view.setBackground(Color.white);


        songs = playList.getSongsOfPlayList();

        for (Song song: songs) {
            SingleSongPanel singleSongPanel = new SingleSongPanel(song.getArtistName() , song.getAlbumName() , song.getTitle() , getImageFromByte(song.getArtWork()) , song , playList);
            view.add(singleSongPanel);
        }

        view.add(new SortPlayListSong());

        JScrollPane scrollPane = new JScrollPane(view);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        myFrame.add(scrollPane , BorderLayout.CENTER);

        scrollPane.repaint();
        scrollPane.validate();
        myFrame.repaint();
        myFrame.validate();
        scrollPane.setVisible(true);
    }


    public SongsShowController(MainFrame myFrame , MainPanel view) {
        view.removeAll();
        view.setLayout(new BoxLayout(view , BoxLayout.Y_AXIS));
        view.setBackground(Color.white);


        songs = new ArrayList<>();

        songs = readObjecFromFile(FILE_PATH , songs);

        for (Song song: songs) {
            SingleSongPanel singleSongPanel = new SingleSongPanel(song.getArtistName() , song.getAlbumName() , song.getTitle() , getImageFromByte(song.getArtWork()) , song);
            view.add(singleSongPanel);
        }

        JScrollPane scrollPane = new JScrollPane(view);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        myFrame.add(scrollPane , BorderLayout.CENTER);

        scrollPane.repaint();
        scrollPane.validate();
        myFrame.repaint();
        myFrame.validate();
        scrollPane.setVisible(true);
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
