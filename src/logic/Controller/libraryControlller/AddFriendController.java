package logic.Controller.libraryControlller;

import graphic.MainFrame;
import graphic.variouspart.additem.AddSongPanel;
import logic.Friend;

import javax.swing.plaf.FileChooserUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AddFriendController implements ActionListener {

    private final static String FILE_FRIEND_PATH = "D:\\friend.bin";
    AddSongPanel addSongPanel;
    MainFrame myFrame;

    public AddFriendController(MainFrame myFrame) {
        addSongPanel = new AddSongPanel(this , "Please Enter Your Friend IP : ");
        this.myFrame = myFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String IP = addSongPanel.getJTextFieldText();
        myFrame.getClient().connect(IP);
        myFrame.getClient().setRequest(IP , "GetUserName");


    }



}
