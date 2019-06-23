package MusicHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayListener implements ActionListener {

    private Thread thread;

    public PlayListener(Thread thread){

        this.thread = thread;
    }

    public void actionPerformed(ActionEvent event){

        thread.start();
    }
}
