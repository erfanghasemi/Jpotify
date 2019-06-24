package logic.Controller.libraryControlller;

import MusicHandler.MusicThread;
import MusicHandler.PauseListener;
import MusicHandler.PlayListener;
import graphic.MainFrame;
import graphic.south.SongInfoPanel;
import graphic.west.ImagePanel;
import logic.Song;

import javax.swing.*;
import java.awt.*;

public class PlaySongController {

    public PlaySongController(MainFrame myFrame , Song song) {

        resetImagePanel(myFrame.getWest().getImagePanel() , getImageFromByte(song.getArtWork()));
        resetInfoSong(myFrame.getSouth().getSongInfoPanel() , song);

        MusicThread musicThread = new MusicThread(song);
        Thread thread = new Thread(musicThread);

        myFrame.getSouth().getPlayerBar().getPlay().addActionListener(new PlayListener(thread , musicThread));
        myFrame.getSouth().getPlayerBar().getPlay().doClick();
        myFrame.getSouth().getPlayerBar().getPause().addActionListener(new PauseListener(musicThread));

    }



















    public Image getImageFromByte(byte[] imageBytes){
        byte[] byteArray = imageBytes;
        ImageIcon imageIcon = new ImageIcon(byteArray);
        Image image = imageIcon.getImage();
        return image;
    }


    public void resetImagePanel(ImagePanel imagePanel , Image artWork){
        imagePanel.removeAll();

        imagePanel.setBackground(Color.WHITE);
        imagePanel.setLayout(new BorderLayout());

        JLabel artWorkLabel = new JLabel();

        Image image = artWork;
        Image newImg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newImg);

        artWorkLabel.setIcon(imageIcon);

        artWorkLabel.setPreferredSize(new Dimension(200 , 200));

        imagePanel.add(artWorkLabel);


        imagePanel.repaint();
        imagePanel.validate();

        imagePanel.setVisible(true);
    }


    public void resetInfoSong(SongInfoPanel songInfoPanel , Song song){

        songInfoPanel.removeAll();

        songInfoPanel.setPreferredSize(new Dimension(200, 250));
        songInfoPanel.setBackground(Color.white);
        songInfoPanel.setLayout(new GridLayout(3 , 1 , 5 , 5 ));

        JLabel nameOfAlbum = new JLabel(song.getAlbumName());
        JLabel nameOfArtist = new JLabel(song.getArtistName());
        JLabel nameOfSong = new JLabel(song.getTitle());

        nameOfSong.setHorizontalAlignment(JLabel.CENTER);
        nameOfArtist.setHorizontalAlignment(JLabel.CENTER);
        nameOfAlbum.setHorizontalAlignment(JLabel.CENTER);


        songInfoPanel.add(nameOfSong);
        songInfoPanel.add(nameOfAlbum);
        songInfoPanel.add(nameOfArtist);

        songInfoPanel.repaint();
        songInfoPanel.validate();
        songInfoPanel.setVisible(true);
    }


}
