package dino.beatmap;
import java.io.File;

import dino.extension.ImageShower;
import dino.extension.beatmapException;

public class beatmap {
    ImageShower is;
    public beatmap(){

    }
    public void read_beatmap(String folder_path) throws beatmapException{
        if(folder_path.contains(".")){
            throw new beatmapException("Error: The beatmap only read the folder!");
        }
        if(!new File(folder_path+"/Songs/play.wav").exists()||!new File(folder_path+"/main.map").exists()){
            throw new beatmapException("Error: base beatmap file is missing!");
        }
        if(new File(folder_path+"/Skins/dragon.gif").exists()){
            is.addFileToCache(folder_path+"/Skins/dragon.gif","dino");
        }
        if(new File(folder_path+"/Skins/obstacle.png").exists()){

        }
        if(new File(folder_path+"/Skins/bird.gif").exists()){
            //TODO: add configuration in this if statement
        }
    }
}
