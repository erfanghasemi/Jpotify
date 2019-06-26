package MusicHandler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MuteListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Audio.setMasterOutputVolume(0);
    }
}
