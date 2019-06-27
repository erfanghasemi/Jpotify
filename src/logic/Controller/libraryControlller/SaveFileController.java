package logic.Controller.libraryControlller;

import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;

import com.mpatric.mp3agic.UnsupportedTagException;

import graphic.variouspart.additem.AddSongPanel;
import logic.Song;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SaveFileController {

	private static final String FILE_PATH = "D:\\avi.bin";

    public SaveFileController(String address) {
    	Song addedSong = new Song(address);
    	attachInformation(addedSong);
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
			song.setArtWork(id3v2Tag.getAlbumImage());
			song.setFrames(mp3file.getFrameCount());

		}
    	catch (InvalidDataException | IOException | UnsupportedTagException e){
    		e.printStackTrace();
		}

	}

	public void writeObjectToFile(Song song) {
		if(true){
			try {
                if((new File(FILE_PATH).exists())) {
                    FileOutputStream fileOut = new FileOutputStream(FILE_PATH, true);
                    AppendingObjectOutputStream objectOut = new AppendingObjectOutputStream(fileOut);
                    objectOut.writeObject(song);
                }
                else{
                    FileOutputStream fileOut = new FileOutputStream(FILE_PATH, true);
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(song);
                }



			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}


    public class AppendingObjectOutputStream extends ObjectOutputStream {

        public AppendingObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            // do not write a header, but reset:
            // this line added after another question
            // showed a problem with the original
            reset();
        }

    }
}
