package MusicHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseListener implements ActionListener {

    private MusicThread musicThread;

    public PauseListener(MusicThread musicThread){
        this.musicThread = musicThread;
    }

    public void actionPerformed (ActionEvent event){
        musicThread.mp3Pause();
    }
}
