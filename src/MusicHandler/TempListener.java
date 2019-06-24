package MusicHandler;

import javazoom.jl.decoder.JavaLayerException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class TempListener implements ActionListener {

    private MusicThread musicThread;

    public TempListener(MusicThread musicThread){
        this.musicThread = musicThread;
    }

    public void actionPerformed(ActionEvent event){
        try {
            musicThread.seekTo(5000);
        } catch (JavaLayerException | IOException e) {
            e.printStackTrace();
        }
    }
}
