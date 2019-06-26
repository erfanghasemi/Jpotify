package graphic.center;

import graphic.MainFrame;
import logic.Controller.libraryControlller.SignInController;
import logic.Controller.libraryControlller.SignUpController;


import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainPanel extends JPanel {

    JPanel north , center , centerSouth , centerLeft, centerRight;
    JLabel imageWelcome , labelText;
    JTextField textField;
    JButton submit;

    public MainPanel() {

        setBackground(Color.white);
        setLayout(new BoxLayout(this  , BoxLayout.Y_AXIS));

        setVisible(true);

    }

    public MainPanel(MainFrame mainFrame) {

        if(!(new File("D:\\olk.bin").exists())) {
            setBackground(Color.WHITE);
            setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            north = new JPanel();
            center = new JPanel(new GridBagLayout());
            centerSouth = new JPanel(new BorderLayout());
            centerLeft = new JPanel(new BorderLayout());
            centerRight = new JPanel(new BorderLayout());

            north.setBackground(Color.white);
            center.setBackground(Color.white);
            centerSouth.setBackground(Color.white);
            centerRight.setBackground(Color.white);
            centerLeft.setBackground(Color.white);


            imageWelcome = new JLabel();
            imageWelcome.setBackground(Color.white);


            ImageIcon imageIcon = new ImageIcon("C:\\Users\\01RAYANEH\\Desktop\\Download-Welcome-Transparent-Background.png");
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(350, 250, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);

            imageWelcome.setIcon(imageIcon);

            north.add(imageWelcome, BorderLayout.CENTER);


            textField = new JTextField();
            labelText = new JLabel("User Name:  ");
            submit = new JButton("Submit");


            textField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainFrame.getNorth().getProfilePanel().setUserName(textField.getText());
                    new SignUpController(textField.getText() , mainFrame.getCenter() , mainFrame);
                    textField.setText("");

                }
            });


            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mainFrame.getNorth().getProfilePanel().setUserName(textField.getText());
                    new SignUpController(textField.getText(), mainFrame.getCenter() , mainFrame);
                    textField.setText("");
                }
            });


            GridBagConstraints c = new GridBagConstraints();
            c.fill = GridBagConstraints.HORIZONTAL;

            centerLeft.add(labelText, BorderLayout.CENTER);
            c.ipadx = 40;
            c.ipady = 15;
            c.gridy = 1;
            c.gridx = 0;
            center.add(centerLeft, c);


            centerRight.add(textField, BorderLayout.CENTER);
            c.ipadx = 200;
            c.ipady = 15;
            c.gridy = 1;
            c.gridx = 1;
            center.add(centerRight, c);


            centerSouth.add(submit, BorderLayout.EAST);
            c.ipadx = 20;
            c.ipady = 15;
            c.gridy = 1;
            c.gridx = 3;
            center.add(centerSouth, c);


            add(north);
            add(center);

            mainFrame.add(this, BorderLayout.CENTER);
            setVisible(true);
        }

        else{

            new SignInController(mainFrame);

            mainFrame.getNorth().getProfilePanel().setUserName(mainFrame.getUserName());

            setBackground(Color.white);

            imageWelcome = new JLabel();

            ImageIcon imageIcon = new ImageIcon("C:\\Users\\01RAYANEH\\Desktop\\Download-Welcome-Transparent-Background.png");
            Image image = imageIcon.getImage();
            Image newimg = image.getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
            imageIcon = new ImageIcon(newimg);

            imageWelcome.setIcon(imageIcon);

            add(imageWelcome , BorderLayout.CENTER);

            mainFrame.add(this ,BorderLayout.CENTER);
            setVisible(true);

        }




    }
}
