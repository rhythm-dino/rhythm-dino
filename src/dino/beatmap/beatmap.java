package dino.beatmap;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import dino.extension.*;
import dino.extension.beatmapException;
import dino.beatmap.map;
public class beatmap {
    private String name,background,Author;
    private Double difficulty;
    private ImageShower All_image;
    private map mp;
    private File f;
    private String TimeStamp;
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
    public String getBackground(){return  background;}
    public String getAuthor(){return Author;}
    public String getTimeStamp() { return TimeStamp; }
    public void SetFile(String str){this.f=new File(str);}
    public beatmap(File file){
        this.f=file;
    }
    public beatmap(String str){
        SetFile(str);
    }
    public beatmap(){

    }
    public void Read() throws IOException, mapException {
        InputStream inputstream = new FileInputStream(new File(f.getPath()+"/Config.data"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream,"UTF-8"),512);
        Integer i=0;
        for(String line=bufferedReader.readLine();line!=null;line= bufferedReader.readLine()){
            if(i==0){
                name = line.substring("Name: ".length());
            }
            else if(i==1){
                difficulty = Double.parseDouble(line.substring("Difficulty: ".length()));
            }
            else if(i>1&&i<=6){
                Add_Image(line);
            }
            else if(i==7){
                Author = line.substring("Author: ".length());
            }
            else if(i==8){
                Long tmp = Long.parseLong(line.substring("TimeStamp: ".length()));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                TimeStamp = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(tmp))));
            }
            else if(i==9){
                mp.Readmap(f.getPath()+line.substring("MapName: ".length()));
            }
            i++;
        }
    }
    private void Add_Image(String line){
        if(line.startsWith("Dino: ")){
            if(line.substring("Dino: ".length())==""){
                return;
            }
            All_image.addFileToCache(line.substring("Dino: ".length()),"Dino");
        }
        else if(line.startsWith("Obstacle: ")){
            if(line.substring("Obstacle: ".length())==""){
                return;
            }
            All_image.addFileToCache(line.substring("Obstacle: ".length()),"Obstacle");
        }
        else if(line.startsWith("LongObstacle: ")){
            if(line.substring("LongObstacle: ".length())==""){
                return;
            }
            All_image.addFileToCache(line.substring("LongObstacle: ".length()),"LongObstacle");
        }
        else if(line.startsWith("DynamicObstacle: ")){
            if(line.substring("DynamicObstacle: ".length())==""){
                return;
            }
            All_image.addFileToCache(line.substring("DynamicObstacle: ".length()),"DynamicObstacle");
        }
        else if(line.startsWith("Background: ")){
            if(line.substring("Background: ".length())==""){
                return;
            }
            background = line.substring("Background: ".length());
        }
    }
}
