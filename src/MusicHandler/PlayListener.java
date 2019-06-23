package MusicHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayListener implements ActionListener {

    private Thread thread;
    private MusicThread musicThread;
    private int i = 1;

    public PlayListener(Thread thread, MusicThread musicThread) {

        this.thread = thread;
        this.musicThread = musicThread;

    }

    public void actionPerformed(ActionEvent event) {

        if (i == 1) {

            thread.start();
            i++;

        } else {
            musicThread.mp3Resume();
        }

    }
}
