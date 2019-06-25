package graphic.south;

import MusicHandler.*;
import graphic.MainFrame;
import logic.Album;
import logic.Controller.libraryControlller.PlaySongController;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class PlayerBarPanel extends JPanel {

    JPanel optionOfPlayPanel , playSliderPanel;
    JSlider bar;
    JLabel endLabelTime;
    JLabel startlabelTime;
    JButton play , addToShare , addToFavourite , pause , nextSong , previousSong ,shuffle , repeat;


    public PlayerBarPanel() {

        setPreferredSize(new Dimension(250, 250));
        setBackground(Color.white);
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));
/*

        optionOfPlayPanel = new JPanel();
        playSliderPanel = new JPanel();

        playSliderPanel.setBackground(Color.white);
        playSliderPanel.setLayout(new GridBagLayout());

        optionOfPlayPanel.setBackground(Color.white);

        startlabelTime = new JLabel("2:32      ");
        bar = new JSlider(0 , 100 , 50);
        endLabelTime = new JLabel("    5:36");


        bar.setEnabled(true);
        bar.setPaintTicks(false);
        bar.setPaintLabels(false);
        bar.setPreferredSize(new Dimension(400 , 25));

        playSliderPanel.add(startlabelTime);
        playSliderPanel.add(bar);
        playSliderPanel.add(endLabelTime);


        play = new JButton("Play");
        addToFavourite = new JButton("Favourite");
        addToShare = new JButton("Share");
        pause = new JButton("Pause");
        nextSong = new JButton("Next");
        previousSong = new JButton("Pervious");
        repeat =new JButton("Repeat");
        shuffle = new JButton("Shuffle");

        optionOfPlayPanel.add(shuffle);
        optionOfPlayPanel.add(addToFavourite);
        optionOfPlayPanel.add(previousSong);
        optionOfPlayPanel.add(pause);
        optionOfPlayPanel.add(play);
        optionOfPlayPanel.add(nextSong);
        optionOfPlayPanel.add(addToShare);
        optionOfPlayPanel.add(repeat);

        add(playSliderPanel);
        add(optionOfPlayPanel);
*/

        setVisible(true);
    }





    public PlayerBarPanel(MainFrame myFrame , ArrayList<Song> songs, Song song , Thread thread , MusicThread  musicThread) {

        setPreferredSize(new Dimension(250, 250));
        setBackground(Color.white);
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

        optionOfPlayPanel = new JPanel();
        playSliderPanel = new JPanel();

        playSliderPanel.setBackground(Color.white);
        playSliderPanel.setLayout(new GridBagLayout());

        optionOfPlayPanel.setBackground(Color.white);

        startlabelTime = new JLabel("2:32      ");
        bar = new JSlider(0 , 100 , 50);
        endLabelTime = new JLabel("    5:36");


        bar.setEnabled(true);
        bar.setPaintTicks(false);
        bar.setPaintLabels(false);
        bar.setPreferredSize(new Dimension(400 , 25));

        playSliderPanel.add(startlabelTime);
        playSliderPanel.add(bar);
        playSliderPanel.add(endLabelTime);


        play = new JButton("Play");
        play.addActionListener(new PlayListener(thread , musicThread));


        addToFavourite = new JButton("Favourite");
        addToFavourite.addActionListener(new FavouriteListener(song));

        addToShare = new JButton("Share");
        addToFavourite.addActionListener(new ShareListener(song));

        pause = new JButton("Pause");
        pause.addActionListener(new PauseListener(musicThread));


        repeat =new JButton("Repeat");

        shuffle = new JButton("Shuffle");
        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int randomIndex = random.nextInt(songs.size());
                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                try {
                    new PlaySongController(myFrame , songs.get(randomIndex));
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                myFrame.repaint();
                myFrame.validate();

            }
        });


        optionOfPlayPanel.add(shuffle);
        optionOfPlayPanel.add(addToFavourite);
        optionOfPlayPanel.add(pause);
        optionOfPlayPanel.add(play);
        optionOfPlayPanel.add(addToShare);
        optionOfPlayPanel.add(repeat);

        add(playSliderPanel);
        add(optionOfPlayPanel);

        setVisible(true);
    }






    public PlayerBarPanel(MainFrame myFrame ,  Song song , Thread thread , MusicThread  musicThread, Album album) {

        setPreferredSize(new Dimension(250, 250));
        setBackground(Color.white);
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

        optionOfPlayPanel = new JPanel();
        playSliderPanel = new JPanel();

        playSliderPanel.setBackground(Color.white);
        playSliderPanel.setLayout(new GridBagLayout());

        optionOfPlayPanel.setBackground(Color.white);

        startlabelTime = new JLabel("2:32      ");
        bar = new JSlider(0 , 100 , 50);
        endLabelTime = new JLabel("    5:36");


        bar.setEnabled(true);
        bar.setPaintTicks(false);
        bar.setPaintLabels(false);
        bar.setPreferredSize(new Dimension(400 , 25));

        playSliderPanel.add(startlabelTime);
        playSliderPanel.add(bar);
        playSliderPanel.add(endLabelTime);


        play = new JButton("Play");
        play.addActionListener(new PlayListener(thread , musicThread));


        addToFavourite = new JButton("Favourite");
        addToFavourite.addActionListener(new FavouriteListener(song));

        addToShare = new JButton("Share");
        addToFavourite.addActionListener(new ShareListener(song));

        pause = new JButton("Pause");
        pause.addActionListener(new PauseListener(musicThread));

        nextSong = new JButton("Next");
        nextSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                try {

                    new PlaySongController(myFrame ,album.getAlbumSongs().get(findNextSong(song , album.getAlbumSongs())) ,album );
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                myFrame.repaint();
                myFrame.validate();
            }
        });



        previousSong = new JButton("Pervious");
        previousSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                try {
                    new PlaySongController(myFrame ,album.getAlbumSongs().get(findPerviousSong(song , album.getAlbumSongs())) ,album );
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                myFrame.repaint();
                myFrame.validate();
            }
        });

        repeat =new JButton("Repeat");

        shuffle = new JButton("Shuffle");
        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int randomIndex = random.nextInt(album.getAlbumSongs().size());
                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                try {
                    new PlaySongController(myFrame , album.getAlbumSongs().get(randomIndex) ,album);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                myFrame.repaint();
                myFrame.validate();

            }
        });


        optionOfPlayPanel.add(shuffle);
        optionOfPlayPanel.add(addToFavourite);
        optionOfPlayPanel.add(previousSong);
        optionOfPlayPanel.add(pause);
        optionOfPlayPanel.add(play);
        optionOfPlayPanel.add(nextSong);
        optionOfPlayPanel.add(addToShare);
        optionOfPlayPanel.add(repeat);

        add(playSliderPanel);
        add(optionOfPlayPanel);

        setVisible(true);
    }







    public PlayerBarPanel(MainFrame myFrame , Song song , Thread thread , MusicThread  musicThread, PlayList playList) {

        setPreferredSize(new Dimension(250, 250));
        setBackground(Color.white);
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

        optionOfPlayPanel = new JPanel();
        playSliderPanel = new JPanel();

        playSliderPanel.setBackground(Color.white);
        playSliderPanel.setLayout(new GridBagLayout());

        optionOfPlayPanel.setBackground(Color.white);

        startlabelTime = new JLabel("2:32      ");
        bar = new JSlider(0 , 100 , 50);
        endLabelTime = new JLabel("    5:36");


        bar.setEnabled(true);
        bar.setPaintTicks(false);
        bar.setPaintLabels(false);
        bar.setPreferredSize(new Dimension(400 , 25));

        playSliderPanel.add(startlabelTime);
        playSliderPanel.add(bar);
        playSliderPanel.add(endLabelTime);


        play = new JButton("Play");
        play.addActionListener(new PlayListener(thread , musicThread));


        addToFavourite = new JButton("Favourite");
        addToFavourite.addActionListener(new FavouriteListener(song));

        addToShare = new JButton("Share");
        addToFavourite.addActionListener(new ShareListener(song));

        pause = new JButton("Pause");
        pause.addActionListener(new PauseListener(musicThread));

        nextSong = new JButton("Next");
        nextSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                try {

                    new PlaySongController(myFrame ,playList.getSongsOfPlayList().get(findNextSong(song , playList.getSongsOfPlayList())) ,playList );
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                myFrame.repaint();
                myFrame.validate();
            }
        });



        previousSong = new JButton("Pervious");
        previousSong.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                try {
                    new PlaySongController(myFrame ,playList.getSongsOfPlayList().get(findPerviousSong(song , playList.getSongsOfPlayList())) ,playList );
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                myFrame.repaint();
                myFrame.validate();
            }
        });

        repeat =new JButton("Repeat");


        shuffle = new JButton("Shuffle");
        shuffle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Random random = new Random();
                int randomIndex = random.nextInt(playList.getSongsOfPlayList().size());
                myFrame.remove(myFrame.getSouth());
                MainPanel newMainSouth = new MainPanel(myFrame);
                myFrame.setSouth(newMainSouth);
                try {
                    new PlaySongController(myFrame , playList.getSongsOfPlayList().get(randomIndex) , playList);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
                myFrame.repaint();
                myFrame.validate();

            }
        });


        optionOfPlayPanel.add(shuffle);
        optionOfPlayPanel.add(addToFavourite);
        optionOfPlayPanel.add(previousSong);
        optionOfPlayPanel.add(pause);
        optionOfPlayPanel.add(play);
        optionOfPlayPanel.add(nextSong);
        optionOfPlayPanel.add(addToShare);
        optionOfPlayPanel.add(repeat);

        add(playSliderPanel);
        add(optionOfPlayPanel);

        setVisible(true);
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















































    public JButton getPlay() {
        return play;
    }

    public JButton getAddToShare() {
        return addToShare;
    }

    public JButton getAddToFavourite() {
        return addToFavourite;
    }

    public JButton getPause() {
        return pause;
    }

    public JButton getNextSong() {
        return nextSong;
    }

    public JButton getPreviousSong() {
        return previousSong;
    }

    public JButton getShuffle() {
        return shuffle;
    }

    public JButton getRepeat() {
        return repeat;
    }

    public JSlider getBar(){
        return bar;
    }
}
