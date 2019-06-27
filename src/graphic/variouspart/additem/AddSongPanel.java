package graphic.variouspart.additem;

import graphic.center.MainPanel;
import logic.Controller.libraryControlller.*;
import logic.PlayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSongPanel extends JFrame {
    private static final String BTN_TXT = "Enter";
    private static final int WIDTH = 300, HEIGHT = 100;


    private JTextField textField;
    private JButton btn;

    public AddSongPanel(RenamePlayListController controller, String labelText){
        super();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel(labelText);
        add(label, BorderLayout.PAGE_START);
        textField = new JTextField();
        textField.addActionListener(controller);
        add(textField, BorderLayout.CENTER);
        btn = new JButton(BTN_TXT);
        btn.addActionListener(controller);
        add(btn, BorderLayout.PAGE_END);
        setSize(WIDTH, HEIGHT);
        this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width / 2 - this.getSize().getWidth() / 2)
                , (int) (Toolkit.getDefaultToolkit().getScreenSize().height / 2 - this.getSize().getHeight() / 2));
        setVisible(true);
    }


    public AddSongPanel(AddSongPlayListController controller, String labelText, MainPanel view){
        super();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel(labelText);
        add(label, BorderLayout.PAGE_START);
        textField = new JTextField();
        textField.addActionListener(controller);
        add(textField, BorderLayout.CENTER);
        btn = new JButton(BTN_TXT);
        btn.addActionListener(controller);
        add(btn, BorderLayout.PAGE_END);
        setSize(WIDTH, HEIGHT);
        this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width / 2 - this.getSize().getWidth() / 2)
                , (int) (Toolkit.getDefaultToolkit().getScreenSize().height / 2 - this.getSize().getHeight() / 2));

        setVisible(true);
    }



    public AddSongPanel(AddFriendController controller, String labelText){
        super();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel(labelText);
        add(label, BorderLayout.PAGE_START);
        textField = new JTextField();
        textField.addActionListener(controller);
        add(textField, BorderLayout.CENTER);
        btn = new JButton(BTN_TXT);
        btn.addActionListener(controller);
        add(btn, BorderLayout.PAGE_END);
        setSize(WIDTH, HEIGHT);
        this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width / 2 - this.getSize().getWidth() / 2)
                , (int) (Toolkit.getDefaultToolkit().getScreenSize().height / 2 - this.getSize().getHeight() / 2));

        setVisible(true);
    }



    public AddSongPanel(SaveFileController controller , String labelText){
        super();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel(labelText);
        add(label, BorderLayout.PAGE_START);
        textField = new JTextField();
        textField.addActionListener(controller);
        add(textField, BorderLayout.CENTER);
        btn = new JButton(BTN_TXT);
        btn.addActionListener(controller);
        add(btn, BorderLayout.PAGE_END);
        setSize(WIDTH, HEIGHT);
        this.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().width / 2 - this.getSize().getWidth() / 2)
                , (int) (Toolkit.getDefaultToolkit().getScreenSize().height / 2 - this.getSize().getHeight() / 2));
        setVisible(true);
    }


    public String getJTextFieldText() {
        return textField.getText();
    }

}
