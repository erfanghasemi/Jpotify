package MusicHandler;

import graphic.MainFrame;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import logic.Song;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MusicThread implements Runnable {

    private boolean isPaused = false;
    private Song song;
    private AdvancedPlayer player;
    private boolean seekTo = false;
    private int frame;
    private Boolean exit;
    private MainFrame mainFrame;

    public MusicThread(Song song , MainFrame mainFrame) throws FileNotFoundException {
        this.song = song;
        this.mainFrame = mainFrame;
        exit = false;
    }


    public MusicThread(Song song) throws FileNotFoundException {
        this.song = song;
       this.mainFrame = mainFrame;
        exit = false;
    }

    public void run() {


        String songTime = showTimeString(song.getLengthOfSong());
        mainFrame.getSouth().getPlayerBar().getEndLabelTime().setText("   " + songTime);
        mainFrame.getSouth().getPlayerBar().getStartlabelTime().setText("00:00" + "   ");

        do {

            int currentFrame = 0;
            int framePerUnitTick = 0;
            int framePerSecond = 0;
            long currentSecond = 0;

            try(FileInputStream fileInputStream = new FileInputStream(song.getAddress())){

                player = new AdvancedPlayer(fileInputStream);

                if (seekTo) {
                    player.play(frame, frame + 1);
                    currentFrame = frame;
                    framePerSecond = 0;
                    currentSecond = (long) frame / (song.getFrames() / song.getLengthOfSong());
                }

                while (player.play(1) && !(exit)){

                    if (isPaused){
                        synchronized (player){
                            player.wait();
                        }
                    }

                    currentFrame++;
                    framePerUnitTick++;
                    framePerSecond++;

                    if(framePerSecond > (song.getFrames() / song.getLengthOfSong())){
                        currentSecond++;
                        mainFrame.getSouth().getPlayerBar().getStartlabelTime().setText(showTimeString(currentSecond));
                        framePerSecond = 0;
                    }


                    if(framePerUnitTick > (song.getFrames() / 100)){
                        int i = mainFrame.getSouth().getPlayerBar().getBar().getValue();
                        mainFrame.getSouth().getPlayerBar().getBar().setValue( i + 1);
                        framePerUnitTick = 0;
                    }

                    mainFrame.repaint();
                    mainFrame.validate();
                }

                if (currentFrame > song.getFrames() - 10){
                    setExitThread();
                    break;
                }

            } catch (JavaLayerException | InterruptedException | IOException e) {
                e.printStackTrace();
            }
        }while (seekTo);


    }

    public void mp3Pause(){
        this.isPaused = true;
    }

    public void setExitThread(){
        exit  = true;
    }


    public void mp3Resume(){

        this.isPaused = false;
        synchronized (player){
            player.notifyAll();
        }
    }

    public void seekTo(int frame) {
        this.frame = frame;
        seekTo = true;
        player.close();
    }

    public Song getSong(){
        return song;
    }



    public String showTimeString(long second){

        long minutePart = second / 60;
        long secondPart =  second - (minutePart * 60);

        if(secondPart < 10){
            return "0" + minutePart  + ":0" + secondPart + "    ";
        }else {
            return "0" + minutePart + ":" + secondPart + "    ";
        }

    }








}