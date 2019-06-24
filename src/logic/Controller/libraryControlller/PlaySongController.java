package logic.Controller.libraryControlller;

import MusicHandler.*;
import graphic.MainFrame;
import graphic.south.MainPanel;
import graphic.south.SongInfoPanel;
import graphic.variouspart.singlesong.SingleSongPanel;
import graphic.west.ImagePanel;
import logic.Album;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PlaySongController {

    private static ArrayList<MusicThread> activeThreads = new ArrayList<>();


    Song songp;

    public PlaySongController(MainFrame myFrame , Song song) {

        resetImagePanel(myFrame.getWest().getImagePanel() , getImageFromByte(song.getArtWork()));
        resetInfoSong(myFrame.getSouth().getSongInfoPanel() , song);

            MusicThread musicThread = new MusicThread(song);
            activeThreads.add(musicThread);
            Thread thread = new Thread(musicThread);
        if(activeThreads.size() == 2){
            activeThreads.get(0).exitThread();
            activeThreads.remove(0);
        }

        myFrame.getSouth().getPlayerBar().getPause().addActionListener(new PauseListener(musicThread));
        myFrame.getSouth().getPlayerBar().getPlay().addActionListener(new PlayListener(thread , musicThread));
        myFrame.getSouth().getPlayerBar().getPlay().doClick();
        myFrame.getSouth().getPlayerBar().getAddToFavourite().addActionListener(new FavouriteListener(song));
        myFrame.getSouth().getPlayerBar().getAddToShare().addActionListener(new ShareListener(song));

    }


    public PlaySongController(MainFrame myFrame , Song song , Album album) {

        resetImagePanel(myFrame.getWest().getImagePanel() , getImageFromByte(song.getArtWork()));
        resetInfoSong(myFrame.getSouth().getSongInfoPanel() , song);

        MusicThread musicThread = new MusicThread(song);
        Thread thread = new Thread(musicThread);
        activeThreads.add(musicThread);

        if(activeThreads.size() == 2){
            activeThreads.get(0).exitThread();
            activeThreads.remove(0);
        }

        myFrame.getSouth().getPlayerBar().getPlay().addActionListener(new PlayListener(thread , activeThreads.get(0)));
        myFrame.getSouth().getPlayerBar().getPause().addActionListener(new PauseListener(musicThread));
        myFrame.getSouth().getPlayerBar().getAddToFavourite().addActionListener(new FavouriteListener(song));
        myFrame.getSouth().getPlayerBar().getAddToShare().addActionListener(new ShareListener(song));

        myFrame.getSouth().getPlayerBar().getPlay().doClick();

        myFrame.getSouth().getPlayerBar().getNextSong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                new PlaySongController(myFrame , album.getAlbumSongs().get(findNextSong(song , album.getAlbumSongs())) , album);
                myFrame.repaint();
                myFrame.validate();
             }
        });

        myFrame.getSouth().getPlayerBar().getPreviousSong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                new PlaySongController(myFrame , album.getAlbumSongs().get(findPerviousSong(song,album.getAlbumSongs())) , album);
                myFrame.repaint();
                myFrame.validate();
            }
        });

    }




    public PlaySongController(MainFrame myFrame , Song song , PlayList playList) {

        resetImagePanel(myFrame.getWest().getImagePanel() , getImageFromByte(song.getArtWork()));
        resetInfoSong(myFrame.getSouth().getSongInfoPanel() , song);

        MusicThread musicThread = new MusicThread(song);
        Thread thread = new Thread(musicThread);
        activeThreads.add(musicThread);

        if(activeThreads.size() == 2){
            activeThreads.get(0).exitThread();
            activeThreads.remove(0);
        }

        myFrame.getSouth().getPlayerBar().getPlay().addActionListener(new PlayListener(thread , activeThreads.get(0)));
        myFrame.getSouth().getPlayerBar().getPause().addActionListener(new PauseListener(musicThread));
        myFrame.getSouth().getPlayerBar().getAddToFavourite().addActionListener(new FavouriteListener(song));
        myFrame.getSouth().getPlayerBar().getAddToShare().addActionListener(new ShareListener(song));

        myFrame.getSouth().getPlayerBar().getPlay().doClick();

        myFrame.getSouth().getPlayerBar().getNextSong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                new PlaySongController(myFrame , playList.getSongsOfPlayList().get(findNextSong(song , playList.getSongsOfPlayList())) , playList);
                myFrame.repaint();
                myFrame.validate();
            }
        });

        myFrame.getSouth().getPlayerBar().getPreviousSong().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                new PlaySongController(myFrame , playList.getSongsOfPlayList().get(findPerviousSong(song,playList.getSongsOfPlayList())) , playList);
                myFrame.repaint();
                myFrame.validate();
            }
        });

    }




    public int findNextSong(Song song , ArrayList<Song> songs){

        int indexOfThisSong = 0;

        for ( Song song1: songs) {
            if(song.getTitle().equals(song1.getTitle())){
                break;
            }
            indexOfThisSong++;
        }

        if(indexOfThisSong == (songs.size() - 1)){
            return 0;
        }
        else {
           return indexOfThisSong + 1;
        }
    }




    public int findPerviousSong(Song song , ArrayList<Song> songs){

        int indexOfThisSong = 0;

        for ( Song song1: songs) {
            if(song.getTitle().equals(song1.getTitle())){
                break;
            }
            indexOfThisSong++;
        }

        if(indexOfThisSong == 0){
            return songs.size() - 1;
        }
        else {
            return indexOfThisSong - 1;
        }
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
