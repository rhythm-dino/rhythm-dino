package dino.extension;

import javax.swing.*;

public interface IDisplayImage {
    public void addFileToCache(String imagePath, String name);
    public void displayImage(String name, JFrame frm, position p, int wsize, int hsize);
    public void moveImageUp(String name, int px, JFrame frame);
//    public void hideImage(String name);
}
