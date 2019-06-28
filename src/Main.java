import graphic.MainFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }


        MainFrame mainFrame = new MainFrame();

    }
}
