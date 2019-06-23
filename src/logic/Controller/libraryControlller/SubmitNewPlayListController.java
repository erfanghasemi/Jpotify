package logic.Controller.libraryControlller;

import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class SubmitNewPlayListController {

    private ArrayList<Song> songs;
    private static final String FILE_PATH_SONGS = "D:\\avi.bin";
    private static final String FILE_PATH_PLAYLIST = "D:\\kia.bin";

    public SubmitNewPlayListController(ArrayList<String> addedSongTitle , String title) {

        songs = new ArrayList<>();
        readObjecFromFile(FILE_PATH_SONGS, songs);
        PlayList newPlayList = new PlayList(title);
        findAddedSong(songs , addedSongTitle , newPlayList);
        writeObjectToFile(newPlayList);

    }



    public ArrayList<Song> readObjecFromFile(String path , ArrayList<Song> songs) {

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (true) {
                    Song song = (Song) objectIn.readObject();
                    songs.add(song);
                }
            }
            catch(EOFException e){
                return songs;
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return songs;
    }


    public void findAddedSong(ArrayList<Song> songs , ArrayList<String> addedSongTitle , PlayList newPlayLIst ){
        if(addedSongTitle == null){
            return;
        }
        else {
            for (String songTitle : addedSongTitle) {
                if (songTitle.equals("")) {
                    continue;
                }
                for (Song addedSong : songs) {
                    if (songTitle.equals(addedSong.getTitle())) {
                        newPlayLIst.getSongsOfPlayList().add(addedSong);
                    }
                }
            }
        }
    }



    private void writeObjectToFile(PlayList playList) {
        if(true){
            try {
                if((new File(FILE_PATH_PLAYLIST).exists())) {
                    FileOutputStream fileOut = new FileOutputStream(FILE_PATH_PLAYLIST, true);
                    AppendingObjectOutputStream objectOut = new AppendingObjectOutputStream(fileOut);
                    objectOut.writeObject(playList);
                }
                else{
                    FileOutputStream fileOut = new FileOutputStream(FILE_PATH_PLAYLIST, true);
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(playList);
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


    public static void refreshPlayListTitleBar(String path , JList list) {

        ArrayList<String> playListTitles= new ArrayList<>();

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (true) {
                    PlayList playList = (PlayList) objectIn.readObject();
                    if(!(playListTitles.contains(playList.getTitle())))
                        playListTitles.add(playList.getTitle());
                }
            }
            catch(EOFException e){
                String[] playListTitlesArr = new String[playListTitles.size()];
                playListTitlesArr = playListTitles.toArray(playListTitlesArr);
                list.setListData(playListTitlesArr);

                return;
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }








}
