package dino.extension;

import javax.swing.*;
import java.util.*;

class ImageEnt{
    private String path;
    private int hashCode;

    ImageEnt(String _filePath, int hs) {
        this.path = _filePath;
        this.hashCode = hs;
    }
    public void setPath(String _filePath) {
        this.path = _filePath;
    }

    public String getPath() {
        return path;
    }

    public int getHashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImageEnt imageEnt = (ImageEnt) o;
        return hashCode == imageEnt.hashCode && path.equals(imageEnt.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, hashCode);
    }
}

public class ImageShower implements IDisplayImage{
    private Map<String, ImageEnt> imagePool; // already showed image. <K,V> = name, imageEnt

    public ImageShower() {
        imagePool = new HashMap<String, ImageEnt>();
    }

    @Override
    public void addFileToCache(String imagePath, String name) {
        int hsc = Objects.hash(name, imagePath);
        imagePool.put(name, new ImageEnt(imagePath, hsc));
    }

    public String getImagePath(String name) {
        return imagePool.get(name).getPath();
    }

    @Override
    public void displayImage(String name, JFrame frm, position p, int wsize, int hsize) {
        ImagePanel panel = new ImagePanel(new ImageIcon(getImagePath(name)).getImage());
        panel.setImage(p, wsize, hsize);
        frm.add(panel);
    }

    @Override
    public void moveImage(String name) {

    }
}
