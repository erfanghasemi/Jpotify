package MusicHandler;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MusicPause implements ActionListener {

    private String url;

    public MusicPause(String url){

        this.url = url;

    }

    public void pauseSong(){

        try{
            File f = new File(url);
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(f);
            clip.open(ais);
            clip.stop(); // <- Doesnt stop the song
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        }catch(Exception exception){System.out.println("Failed To Play The WAV File!");}
    }

    public void actionPerformed(ActionEvent evn){
        pauseSong();
    }
}
