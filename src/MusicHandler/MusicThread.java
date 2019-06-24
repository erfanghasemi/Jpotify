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
    private boolean seekTo = false;
    private int frame;

    public MusicThread(Song song) {
        this.song = song;
    }

    public void run() {

        do {

//            System.out.println("thread is running");
            try(FileInputStream fileInputStream = new FileInputStream(song.getAddress())) {

                player = new AdvancedPlayer(fileInputStream);

                if (seekTo)
                    player.play(frame, frame + 1);

                while (player.play(1)){

//                    System.out.println("music is playing");

                    if (isPaused){
//                        System.out.println("music stopped");
                        synchronized (player){
                            player.wait();
                        }
                    }
                }
//                System.out.println("thread is running out of loop");

            } catch (IOException | JavaLayerException | InterruptedException e) {
                e.printStackTrace();
            }
        }while (seekTo);

    }

    public void mp3Pause(){
        this.isPaused = true;
    }

    public void mp3Resume(){

        this.isPaused = false;
        synchronized (player){
            player.notifyAll();
        }
    }

    public void seekTo(int frame) throws JavaLayerException, IOException {
        this.frame = frame;
        seekTo = true;
        player.close();
    }

}
