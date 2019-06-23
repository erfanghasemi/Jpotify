package MusicHandler;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import logic.Song;

import java.io.FileInputStream;
import java.io.IOException;

public class MusicThread implements Runnable {

    private boolean isPaused = false;
    private Song song;
    private AdvancedPlayer player;

    public MusicThread(Song song) {

        this.song = song;
    }

    public void run() {

        //System.out.println("thread is running");

        try(FileInputStream fileInputStream = new FileInputStream(song.getAddress())) {

            player = new AdvancedPlayer(fileInputStream);

            while (player.play(1)){

                //System.out.println("music is playing");

                if (isPaused){
                    //System.out.println("music stopped");
                    synchronized (player){
                        player.wait();
                    }
                }
            }

        } catch (IOException | JavaLayerException | InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void mp3Pause(){
        this.isPaused = true;
    }




}
