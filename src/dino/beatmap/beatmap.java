package dino.beatmap;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.util.*;
import dino.extension.*;
import dino.extension.beatmapException;
import dino.beatmap.map;
public class beatmap {
    private String name;
    private double difficulty;
    private ImageShower All_image;
    private map mp;
    public ImageShower Get_ImageShower(){
        return All_image;
    }
    public String getName() {
        return name;
    }
    public double getDifficulty() {
        return difficulty;
    }
    public map getMp() {
        return mp;
    }
    public beatmap(){

    }
}
