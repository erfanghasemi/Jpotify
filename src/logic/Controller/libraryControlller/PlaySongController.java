package logic.Controller.libraryControlller;

import MusicHandler.*;
import graphic.MainFrame;
import graphic.south.MainPanel;
import graphic.south.SongInfoPanel;
import graphic.west.ImagePanel;
import logic.Album;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;


public class PlaySongController {

    private static ArrayList<MusicThread> activeThreads = new ArrayList<>();
    private static final String FILE_PATH = "D:\\avi.bin";
    ArrayList<Song> songsList;


    public PlaySongController(MainFrame myFrame , Song song) throws FileNotFoundException {

        resetImagePanel(myFrame.getWest().getImagePanel() , getImageFromByte(song.getArtWork()));

        sortLastPlay(song);


        songsList = new ArrayList<>();
        songsList = readSongFromFile(FILE_PATH , songsList);

            MusicThread musicThread = new MusicThread(song);
            activeThreads.add(musicThread);
            Thread thread = new Thread(musicThread);
        if(activeThreads.size() == 2){
            activeThreads.get(0).setExitThread();

            activeThreads.remove(0);
        }


        myFrame.remove(myFrame.getSouth());
        MainPanel newMainSouth = new MainPanel(myFrame , songsList ,song , musicThread , thread);
        myFrame.setSouth(newMainSouth);

        resetInfoSong(myFrame.getSouth().getSongInfoPanel() , song);

        myFrame.getSouth().getPlayerBar().getPlay().doClick();

        myFrame.repaint();
        myFrame.validate();


/*
        myFrame.getSouth().getPlayerBar().getShuffle().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int randomIndex = random.nextInt(songsList.size());
                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                try {
                    new PlaySongController(myFrame , songsList.get(randomIndex));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                myFrame.repaint();
                myFrame.validate();

            }
        });



        myFrame.getSouth().getPlayerBar().getRepeat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (true && (activeThreads.size() == 0)) {
                    myFrame.remove(myFrame.getSouth());
                    MainPanel newMainSouth = new MainPanel(myFrame);
                    myFrame.setSouth(newMainSouth);
                    try {
                        new PlaySongController(myFrame, song);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    myFrame.repaint();
                    myFrame.validate();
                }
            }
        });
*/

        new SongsShowController(myFrame , myFrame.getCenter());

    }


    public PlaySongController(MainFrame myFrame , Song song , Album album) throws  FileNotFoundException{



        resetImagePanel(myFrame.getWest().getImagePanel() , getImageFromByte(song.getArtWork()));


//        sortLastPlay(song);

        MusicThread musicThread = new MusicThread(song);
        Thread thread = new Thread(musicThread);
        activeThreads.add(musicThread);

        if(activeThreads.size() == 2){
            activeThreads.get(0).setExitThread();
            activeThreads.remove(0);
        }


        myFrame.remove(myFrame.getSouth());
        MainPanel newMainSouth = new MainPanel(myFrame ,song , musicThread , thread , album);
        myFrame.setSouth(newMainSouth);

        resetInfoSong(myFrame.getSouth().getSongInfoPanel() , song);

        myFrame.getSouth().getPlayerBar().getPlay().doClick();

        myFrame.repaint();
        myFrame.validate();

/*

        myFrame.getSouth().getPlayerBar().getShuffle().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int randomIndex = random.nextInt(album.getAlbumSongs().size());
                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                try {
                    new PlaySongController(myFrame , album.getAlbumSongs().get((randomIndex)) , album);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                myFrame.repaint();
                myFrame.validate();

            }
        });


        myFrame.getSouth().getPlayerBar().getRepeat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                while (true) {
                    myFrame.remove(myFrame.getSouth());
                    MainPanel newMainSouth = new MainPanel(myFrame);
                    myFrame.setSouth(newMainSouth);
                    try {
                        new PlaySongController(myFrame, song);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    myFrame.repaint();
                    myFrame.validate();
                }
            }
        });

*/


    }

    public PlaySongController(MainFrame myFrame , Song song , PlayList playList) throws FileNotFoundException {

        resetImagePanel(myFrame.getWest().getImagePanel() , getImageFromByte(song.getArtWork()));


//        sortLastPlay(song);

        MusicThread musicThread = new MusicThread(song);
        Thread thread = new Thread(musicThread);
        activeThreads.add(musicThread);

        if(activeThreads.size() == 2){
            activeThreads.get(0).setExitThread();
            activeThreads.remove(0);
        }



        myFrame.remove(myFrame.getSouth());
        MainPanel newMainSouth = new MainPanel(myFrame ,song , musicThread , thread , playList);
        myFrame.setSouth(newMainSouth);

        resetInfoSong(myFrame.getSouth().getSongInfoPanel() , song);

        myFrame.getSouth().getPlayerBar().getPlay().doClick();

        myFrame.repaint();
        myFrame.validate();


   /*     myFrame.getSouth().getPlayerBar().getShuffle().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int randomIndex = random.nextInt(playList.getSongsOfPlayList().size());
                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                try {
                    new PlaySongController(myFrame ,playList.getSongsOfPlayList().get(randomIndex) , playList);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                myFrame.repaint();
                myFrame.validate();

            }
        });


        myFrame.getSouth().getPlayerBar().getRepeat().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(true) {
                    myFrame.remove(myFrame.getSouth());
                    MainPanel newMainSouth = new MainPanel(myFrame);
                    myFrame.setSouth(newMainSouth);
                    try {
                        new PlaySongController(myFrame, song);
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    myFrame.repaint();
                    myFrame.validate();
                }
            }
        });
*/
    }





    public ArrayList<Song> readSongFromFile(String path, ArrayList<Song> songs) {

        try {
            FileInputStream fileIn = new FileInputStream(FILE_PATH);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (true) {
                    Song song = (Song) objectIn.readObject();
                    songs.add(song);
                }
            } catch (EOFException e) {
                return songs;
            }
        } catch (IOException | ClassNotFoundException e) {
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


    public void sortLastPlay(Song song){

        ArrayList<Song> songs = new ArrayList<>();
        ArrayList<Song> sortedSongs = new ArrayList<>();

        readSongFromFile(FILE_PATH , songs);

        for ( Song song1 : songs) {
            if(song1.getTitle().equals(song.getTitle())){
                sortedSongs.add(song1);
            }
        }

        for ( Song song1: songs) {
            if(!(song1.getTitle().equals(song.getTitle()))){
                sortedSongs.add(song1);
            }
        }


        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Song song1 : sortedSongs) {
                objectOut.writeObject(song1);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

    }


}
