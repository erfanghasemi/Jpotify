package logic.Controller.libraryControlller;

import graphic.west.FileChooserFrame;
import logic.Song;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

public class SaveFileController  extends SongsController implements  ActionListener {

    FileChooserFrame fileChooserFrame;

    public SaveFileController() {
        this.fileChooserFrame = new FileChooserFrame(this);
    }



    @Override
    public void actionPerformed(ActionEvent e) {

    	String address = fileChooserFrame.getJTextFieldText();
    	Song addedSong = new Song(address);
    	attachInformation(addedSong);
    	addSongToArrray(addedSong);






    }

    public void attachInformation(Song song){

	}

	public void addSongToArrray(Song addedSong){
    	songs.add(addedSong);
    	//handle the ahang tekrari ba method equals baraye Song
    }

    public void creatFileSongs(Song addedSong){




	}





}
