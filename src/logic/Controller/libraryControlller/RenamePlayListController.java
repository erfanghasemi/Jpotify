package logic.Controller.libraryControlller;

import graphic.MainFrame;
import graphic.variouspart.additem.AddSongPanel;
import logic.PlayList;
import logic.Song;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

import static logic.Controller.libraryControlller.SubmitNewPlayListController.refreshPlayListTitleBar;

public class RenamePlayListController implements ActionListener {

    AddSongPanel addSongPanel;
    PlayList playList;
    MainFrame view;
    ArrayList<PlayList> playLists;

    private static final String FILE_PATH_PLAYLIST = "D:\\kia.bin";


    public RenamePlayListController(PlayList playList , MainFrame view) {
        addSongPanel = new AddSongPanel(this , "Please Enter Your New Name: ");

        this.playList = playList;
        this.view = view;

        playLists = new ArrayList<>();




    }

    @Override
    public void actionPerformed(ActionEvent e) {

        readObjecFromFile(FILE_PATH_PLAYLIST , playLists);

        changeTitle(playList , playLists);


        try {
            FileOutputStream fileOut = new FileOutputStream(FILE_PATH_PLAYLIST);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (PlayList playList: playLists) {
                objectOut.writeObject(playList);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }

        new PlayListController(view.getCenter());
        refreshPlayListTitleBar("D:\\kia.bin" , view.getWest().getPlaylistPanel().getPlayLists());

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


    public void changeTitle(PlayList playList , ArrayList<PlayList> playLists){
        for (PlayList playList1: playLists) {
            if(playList.getTitle().equals(playList1.getTitle())){
                playList1.setTitle(addSongPanel.getJTextFieldText());

            }
        }
    }


}
