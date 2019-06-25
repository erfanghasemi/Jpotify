package logic.Controller.libraryControlller;

import graphic.center.MainPanel;
import graphic.north.SearchPanel;
import graphic.variouspart.singlesong.SingleSongPanel;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class SearchSongController {

    private static final String FILE_PATH = "D:\\avi.bin";

    private ArrayList<Song> songs;
    private String searchedTitleSong;
    private Song targetSong;

    public SearchSongController(MainPanel view  , SearchPanel searchPanel) {

        songs = new ArrayList<>();

        readObjecFromFile(FILE_PATH , songs);

        targetSong = searchSong(searchPanel.getFieldOfSearchText() , songs);

        if(targetSong == null){
            view.removeAll();
            view.setLayout(new BorderLayout());
            view.setBackground(Color.white);

            JLabel notFoundMessage= new JLabel("Not Found :)");
            notFoundMessage.setFont(new Font("Serif", Font.BOLD, 25));
            notFoundMessage.setHorizontalAlignment(JLabel.CENTER);

            view.add(notFoundMessage , BorderLayout.CENTER);

            view.repaint();
            view.validate();
            view.setVisible(true);

        }
        else{
            view.removeAll();
            view.setLayout(new BoxLayout(view , BoxLayout.Y_AXIS));
            view.setBackground(Color.white);

            SingleSongPanel singleSongPanel = new SingleSongPanel(targetSong.getArtistName() , targetSong.getAlbumName() , targetSong.getTitle() , getImageFromByte(targetSong.getArtWork()) , targetSong);

            view.add(singleSongPanel);

            view.repaint();
            view.validate();
            view.setVisible(true);
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


    public Song searchSong(String searchedTitle , ArrayList<Song> songs){
        Song targetSong = null;

        for ( Song song:songs) {
            if(song.getTitle().equals(searchedTitle)){
                targetSong = song;
            }
        }
        return targetSong;
    }



    public Image getImageFromByte(byte[] imageBytes){
        byte[] byteArray = imageBytes;
        ImageIcon imageIcon = new ImageIcon(byteArray);
        Image image = imageIcon.getImage();
        return image;
    }





}
