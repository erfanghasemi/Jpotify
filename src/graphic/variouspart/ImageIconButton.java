package graphic.variouspart;

import javax.swing.*;
import java.awt.*;

public class ImageIconButton extends ImageIcon {

    public ImageIconButton(String filename , int width , int height) {
        super(filename);
        Image image = this.getImage();
        Image newImg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);
        this.setImage(newImg);
    }
}
