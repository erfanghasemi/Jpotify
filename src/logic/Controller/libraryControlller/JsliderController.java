package logic.Controller.libraryControlller;

import MusicHandler.MusicThread;
import graphic.MainFrame;

public class JsliderController {

    public JsliderController(MainFrame myFrame , MusicThread musicThread) {

        int frame = musicThread.getSong().getFrames();

        int frequency = myFrame.getSouth().getPlayerBar().getBar().getValue() * (frame / 100);

        musicThread.seekTo(frequency);

    }
}
