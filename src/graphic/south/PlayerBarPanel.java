package graphic.south;

import MusicHandler.*;
import graphic.MainFrame;
import graphic.variouspart.ImageIconButton;
import graphic.variouspart.additem.EJSlider;
import logic.Album;
import logic.Controller.libraryControlller.JsliderController;
import logic.Controller.libraryControlller.PlaySongController;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class PlayerBarPanel extends JPanel {

    JPanel optionOfPlayPanel , playSliderPanel;
    private EJSlider bar;
    JLabel endLabelTime;
    JLabel startlabelTime;
    JButton play , addToShare , addToFavourite , pause , nextSong , previousSong ,shuffle , repeat;



    public PlayerBarPanel() {

        setPreferredSize(new Dimension(250, 250));
        setBackground(Color.white);
        setLayout(new BoxLayout(this , BoxLayout.Y_AXIS));

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

        startlabelTime = new JLabel();
        bar = new EJSlider(0 , 100 , 0);
        endLabelTime = new JLabel();


        bar.setEnabled(true);
        bar.setPaintTicks(false);
        bar.setPaintLabels(false);
        bar.setPreferredSize(new Dimension(400 , 25));



        bar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(bar);
                if(bar.getValueIsAdjusting()) {
                    new JsliderController(myFrame, musicThread);
                }
            }
        });


        playSliderPanel.add(startlabelTime);
        playSliderPanel.add(bar);
        playSliderPanel.add(endLabelTime);


        play = new JButton(new ImageIconButton(".\\Icons\\img_153075.png" , 40 , 40));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.addActionListener(new PlayListener(thread , musicThread));


        addToFavourite = new JButton(new ImageIconButton(".\\Icons\\23243-200.png" , 30 , 30));
        addToFavourite.setOpaque(false);
        addToFavourite.setContentAreaFilled(false);
        addToFavourite.setBorderPainted(false);
        addToFavourite.addActionListener(new FavouriteListener(song));

        addToShare = new JButton(new ImageIconButton(".\\Icons\\share-512 (1).png" , 30 , 30));
        addToShare.setOpaque(false);
        addToShare.setContentAreaFilled(false);
        addToShare.setBorderPainted(false);
        addToShare.addActionListener(new ShareListener(song));

        pause = new JButton(new ImageIconButton(".\\Icons\\download.png" , 40 , 40));
        pause.setOpaque(false);
        pause.setContentAreaFilled(false);
        pause.setBorderPainted(false);
        pause.addActionListener(new PauseListener(musicThread));

        bar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(bar);
                if(bar.getValueIsAdjusting()) {
                    new JsliderController(myFrame, musicThread);
                }
            }
        });


        repeat =new JButton(new ImageIconButton(".\\Icons\\274-2743644_refresh-button-repeat-icon-png.png" , 25 , 25));
        repeat.setOpaque(false);
        repeat.setContentAreaFilled(false);
        repeat.setBorderPainted(false);


        shuffle = new JButton(new ImageIconButton(".\\Icons\\media-shuffle.png" , 25 , 25 ));
        shuffle.setOpaque(false);
        shuffle.setContentAreaFilled(false);
        shuffle.setBorderPainted(false);
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
        optionOfPlayPanel.add(play);
        optionOfPlayPanel.add(pause);
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

        startlabelTime = new JLabel( song.getLengthOfSong() + "      ");
        bar = new EJSlider(0 , 100 , 0);
        endLabelTime = new JLabel("    5:36");


        bar.setEnabled(true);
        bar.setPaintTicks(false);
        bar.setPaintLabels(false);
        bar.setPreferredSize(new Dimension(400 , 25));


        bar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(bar);
                if(bar.getValueIsAdjusting()) {
                    new JsliderController(myFrame, musicThread);
                }
            }
        });





        playSliderPanel.add(startlabelTime);
        playSliderPanel.add(bar);
        playSliderPanel.add(endLabelTime);


        play = new JButton(new ImageIconButton(".\\Icons\\img_153075.png" , 40 , 40));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.addActionListener(new PlayListener(thread , musicThread));


        addToFavourite = new JButton(new ImageIconButton(".\\Icons\\23243-200.png" , 30 , 30));
        addToFavourite.setOpaque(false);
        addToFavourite.setContentAreaFilled(false);
        addToFavourite.setBorderPainted(false);
        addToFavourite.addActionListener(new FavouriteListener(song));

        addToShare = new JButton(new ImageIconButton(".\\Icons\\share-512 (1).png" , 30 , 30));
        addToShare.setOpaque(false);
        addToShare.setContentAreaFilled(false);
        addToShare.setBorderPainted(false);
        addToShare.addActionListener(new ShareListener(song));

        pause = new JButton(new ImageIconButton(".\\Icons\\download.png" , 40 , 40));
        pause.setOpaque(false);
        pause.setContentAreaFilled(false);
        pause.setBorderPainted(false);
        pause.addActionListener(new PauseListener(musicThread));

        nextSong = new JButton(new ImageIconButton(".\\Icons\\next-button-png-ahead-button-fastforward-forward-go-next-icon-512.png" ,35 , 35));
        nextSong.setOpaque(false);
        nextSong.setContentAreaFilled(false);
        nextSong.setBorderPainted(false);
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



        previousSong = new JButton(new ImageIconButton(".\\Icons\\previous-button-png-arrow-back-basic-button-control-media-player-previous-512.png" , 40 , 40));
        previousSong.setOpaque(false);
        previousSong.setContentAreaFilled(false);
        previousSong.setBorderPainted(false);
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

        repeat =new JButton(new ImageIconButton(".\\Icons\\274-2743644_refresh-button-repeat-icon-png.png" , 25 , 25));
        repeat.setOpaque(false);
        repeat.setContentAreaFilled(false);
        repeat.setBorderPainted(false);


        shuffle = new JButton(new ImageIconButton(".\\Icons\\media-shuffle.png" , 25 , 25 ));
        shuffle.setOpaque(false);
        shuffle.setContentAreaFilled(false);
        shuffle.setBorderPainted(false);
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
        optionOfPlayPanel.add(play);
        optionOfPlayPanel.add(pause);
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
        bar = new EJSlider(0 , 100 , 0);
        endLabelTime = new JLabel("    5:36");

        bar.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                MainFrame myFrame  = (MainFrame) SwingUtilities.getWindowAncestor(bar);
                if(bar.getValueIsAdjusting()) {
                    new JsliderController(myFrame, musicThread);
                }
            }
        });


        bar.setEnabled(true);
        bar.setPaintTicks(false);
        bar.setPaintLabels(false);
        bar.setPreferredSize(new Dimension(400 , 25));

        playSliderPanel.add(startlabelTime);
        playSliderPanel.add(bar);
        playSliderPanel.add(endLabelTime);


        play = new JButton(new ImageIconButton(".\\Icons\\img_153075.png" , 40 , 40));
        play.setOpaque(false);
        play.setContentAreaFilled(false);
        play.setBorderPainted(false);
        play.addActionListener(new PlayListener(thread , musicThread));


        addToFavourite = new JButton(new ImageIconButton(".\\Icons\\23243-200.png" , 30 , 30));
        addToFavourite.setOpaque(false);
        addToFavourite.setContentAreaFilled(false);
        addToFavourite.setBorderPainted(false);
        addToFavourite.addActionListener(new FavouriteListener(song));



        addToShare = new JButton(new ImageIconButton(".\\Icons\\share-512 (1).png" , 30 , 30));
        addToShare.setOpaque(false);
        addToShare.setContentAreaFilled(false);
        addToShare.setBorderPainted(false);
        addToShare.addActionListener(new ShareListener(song));

        pause = new JButton(new ImageIconButton(".\\Icons\\download.png" , 40 , 40));
        pause.setOpaque(false);
        pause.setContentAreaFilled(false);
        pause.setBorderPainted(false);
        pause.addActionListener(new PauseListener(musicThread));

        nextSong = new JButton(new ImageIconButton(".\\Icons\\next-button-png-ahead-button-fastforward-forward-go-next-icon-512.png" ,35 , 35));
        nextSong.setOpaque(false);
        nextSong.setContentAreaFilled(false);
        nextSong.setBorderPainted(false);
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



        previousSong = new JButton(new ImageIconButton(".\\Icons\\previous-button-png-arrow-back-basic-button-control-media-player-previous-512.png" , 40 , 40));
        previousSong.setOpaque(false);
        previousSong.setContentAreaFilled(false);
        previousSong.setBorderPainted(false);
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

        repeat =new JButton(new ImageIconButton(".\\Icons\\274-2743644_refresh-button-repeat-icon-png.png" , 25 , 25));
        repeat.setOpaque(false);
        repeat.setContentAreaFilled(false);
        repeat.setBorderPainted(false);


        shuffle = new JButton(new ImageIconButton(".\\Icons\\media-shuffle.png" , 25 , 25 ));
        shuffle.setOpaque(false);
        shuffle.setContentAreaFilled(false);
        shuffle.setBorderPainted(false);
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
        optionOfPlayPanel.add(play);
        optionOfPlayPanel.add(pause);
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

    public EJSlider getBar(){
        return bar;
    }

    public JLabel getEndLabelTime() {
        return endLabelTime;
    }

    public void setEndLabelTime(JLabel endLabelTime) {
        this.endLabelTime = endLabelTime;
    }

    public JLabel getStartlabelTime() {
        return startlabelTime;
    }

    public void setStartlabelTime(JLabel startlabelTime) {
        this.startlabelTime = startlabelTime;
    }
}
