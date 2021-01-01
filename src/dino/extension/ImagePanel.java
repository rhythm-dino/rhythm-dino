package dino.extension;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image img;
    private position p;
    private int widthSize, heightSize;
    public ImagePanel(Image img){
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setSize(size);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setLayout(null);
    }

    public int getHeightSize() {
        return heightSize;
    }

    public int getWidthSize() {
        return widthSize;
    }

    public position getP() {
        return p;
    }

    @Override
    protected void paintComponent(Graphics g) {
//        Dimension size = this.getParent().getSize();
        g.drawImage(img, p.getX(), p.getY(), widthSize, heightSize, this);
    }

    public void setImage(position _p, int _widthSize, int _heightSize) {
        this.p = _p;
        this.widthSize = _widthSize;
        this.heightSize = _heightSize;
    }
}
