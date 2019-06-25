package MusicHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TempListener implements ActionListener {

    private MusicThread musicThread;

    public TempListener(MusicThread musicThread){
        this.musicThread = musicThread;
    }

    public void actionPerformed(ActionEvent event){
        musicThread.seekTo(5000);
    }
}
