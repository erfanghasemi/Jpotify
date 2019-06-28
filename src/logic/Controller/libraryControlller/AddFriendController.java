package logic.Controller.libraryControlller;

import graphic.MainFrame;
import graphic.variouspart.additem.AddSongPanel;

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
        writeObjectToFile(IP);

//        try {
//            myFrame.getClient().addIP(addSongPanel.getJTextFieldText());
//        } catch (IOException e1) {
//            e1.printStackTrace();
//        }

    }


    public void writeObjectToFile(String string) {
        if(true){
            try {
                if((new File(FILE_FRIEND_PATH).exists())) {
                    FileOutputStream fileOut = new FileOutputStream(FILE_FRIEND_PATH, true);
                    AppendingObjectOutputStream objectOut = new AppendingObjectOutputStream(fileOut);
                    objectOut.writeObject(string);
                }
                else{
                    FileOutputStream fileOut = new FileOutputStream(FILE_FRIEND_PATH, true);
                    ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                    objectOut.writeObject(string);
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
