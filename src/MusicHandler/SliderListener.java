package MusicHandler;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderListener implements ChangeListener {

    private MusicThread musicThread;

    public SliderListener(MusicThread musicThread){
        this.musicThread = musicThread;
    }

    public synchronized void stateChanged(ChangeEvent e){

        System.out.println("slider changed");
        JSlider slider = (JSlider) e.getSource();

        int frame = musicThread.getSong().getFrames();

        int frequency = slider.getValue() * (frame / 100);

        //System.out.println(frequency);

        musicThread.seekTo(frequency);
    }
}
