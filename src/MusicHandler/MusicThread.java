package MusicHandler;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import logic.Song;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MusicThread implements Runnable {

    private boolean isPaused = false;
    private InputStream inputStream;
    private AdvancedPlayer player;
    private boolean seekTo = false;
    private int frame;
    private Boolean exit;

    public MusicThread(Song song) throws FileNotFoundException {


        exit = false;
        this.inputStream = new FileInputStream(song.getAddress());
    }

    public MusicThread (InputStream inputStream){
        this.inputStream = inputStream;
    }

    public void run() {

        do {

//
            try{

                player = new AdvancedPlayer(this.inputStream);

                if (seekTo)
                    player.play(frame, frame + 1);

                while (player.play(1) && !(exit)){

//                    System.out.println("music is playing");

                    if (isPaused){
//                        System.out.println("music stopped");
                        synchronized (player){
                            player.wait();
                        }
                    }
                }
//                System.out.println("thread is running out of loop");

            } catch (JavaLayerException | InterruptedException e) {
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

}
