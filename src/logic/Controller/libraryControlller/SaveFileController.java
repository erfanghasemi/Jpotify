package logic.Controller.libraryControlller;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;

import com.mpatric.mp3agic.UnsupportedTagException;

import graphic.west.FileChooserFrame;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SaveFileController  extends SongsController implements  ActionListener {

    FileChooserFrame fileChooserFrame;
	private static final String FILE_PATH = "D:\\avi.bin";

    public SaveFileController() {
    	super();
        this.fileChooserFrame = new FileChooserFrame(this);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    	String address = fileChooserFrame.getJTextFieldText();
    	Song addedSong = new Song(address);
    	attachInformation(addedSong);
    	addSongToArrray(addedSong);
		writeObjectToFile(addedSong);

    }


    public void attachInformation(Song song){

    	try {
			Mp3File mp3file = new Mp3File(song.getAddress());
			ID3v2 id3v2Tag = mp3file.getId3v2Tag();

			song.setTitle(id3v2Tag.getTitle());
			song.setAlbumName(id3v2Tag.getAlbum());
			song.setArtistName(id3v2Tag.getArtist());
			song.setLengthOfSong(mp3file.getLengthInSeconds());
			song.setArtWork(getImageFromByte(id3v2Tag.getAlbumImage()));

		}
    	catch (InvalidDataException | IOException | UnsupportedTagException e){
    		e.printStackTrace();
		}

	}


	public void addSongToArrray(Song addedSong){
    	songs.add(addedSong);
    	//handle the ahang tekrari ba method equals baraye Song
    }


	public void writeObjectToFile(Song song) {
		if(true){
			try {
				FileOutputStream fileOut = new FileOutputStream(FILE_PATH  ,true);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
				objectOut.writeObject(song);
				objectOut.close();
				System.out.println("The Object  was succesfully written to a file");

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public Image getImageFromByte(byte[] imageBytes){
		byte[] byteArray = imageBytes;
		ImageIcon imageIcon = new ImageIcon(byteArray);
		Image image = imageIcon.getImage();
    	return image;
	}




}
