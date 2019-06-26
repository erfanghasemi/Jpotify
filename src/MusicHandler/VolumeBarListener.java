package MusicHandler;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class VolumeBarListener implements ChangeListener {

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        float volume = slider.getValue();
        Audio.setMasterOutputVolume(volume / 100);
    }

}
