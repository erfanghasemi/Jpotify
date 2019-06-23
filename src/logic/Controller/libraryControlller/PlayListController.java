package logic.Controller.libraryControlller;

import graphic.center.MainPanel;
import graphic.variouspart.singleplaylist.SinglePlayListPanel;
import logic.PlayList;
import logic.Song;

import javax.swing.*;
import java.awt.*;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class PlayListController {

    protected ArrayList<PlayList> playLists;
    private static final String FILE_PATH_PLAYLIST = "D:\\kia.bin";

    public PlayListController(MainPanel view) {

        view.removeAll();
        view.setLayout(new BoxLayout(view , BoxLayout.Y_AXIS));


        playLists = new ArrayList<>();

        readObjecFromFile(FILE_PATH_PLAYLIST , playLists);

        System.out.println(playLists.get(0).getSongsOfPlayList().get(0).getTitle());

        for (PlayList playList : playLists) {
            if(!(playList.getTitle().equals("Favourite") || playList.getTitle().equals("Share"))) {
                SinglePlayListPanel singlePlayListPanel = new SinglePlayListPanel(playList.getTitle(), getImageFromByte(playList.getSongsOfPlayList().get(0).getArtWork()), playList);
                view.add(singlePlayListPanel);
            }
        }

        view.repaint();
        view.validate();
        view.setVisible(true);

    }

    public ArrayList<PlayList> readObjecFromFile(String path , ArrayList<PlayList> playLists) {

        try {
            FileInputStream fileIn = new FileInputStream(path);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            try {
                while (true) {
                    PlayList playList = (PlayList) objectIn.readObject();
                    playLists.add(playList);
                }
            }
            catch(EOFException e){
                return playLists;
            }
        }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return playLists;
    }


    public Image getImageFromByte(byte[] imageBytes){
        byte[] byteArray = imageBytes;
        ImageIcon imageIcon = new ImageIcon(byteArray);
        Image image = imageIcon.getImage();
        return image;
    }



}
