package graphic.west;

import logic.Controller.libraryControlller.SaveFileController;

import javax.swing.*;
import java.awt.*;

public class FileChooserFrame extends JFrame {
    private static final String BTN_TXT = "Enter";
    private static final String LABEL_TXT = "Enter Your File Path: ";
    private static final int WIDTH = 300, HEIGHT = 100;

    private JTextField textField;
    private JButton btn;

    public FileChooserFrame(SaveFileController controller){
        super();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel(LABEL_TXT);
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
