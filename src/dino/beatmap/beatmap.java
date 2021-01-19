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
    protected String[] imgname = {
            "dino.png",
            "obstacle.png",
            "long_obstacle.png",
            "dynamic_obstacle.png",
            "bg.png"
    };
    public void Read() throws IOException, mapException {
        InputStream inputstream = new FileInputStream(new File(f.getPath()+"/Config.data"));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputstream,"UTF-8"),512);
        Integer i=0;
        for(String line=bufferedReader.readLine();line!=null;line= bufferedReader.readLine()){
            if(i==0){
                name = line.substring("Name: ".length());
            }
            else if(i==1){
                Author = line.substring("Author: ".length());
            }
            else if(i==2){
                difficulty = Double.parseDouble(line.substring("Difficulty: ".length()));
            }
            else if(i==3){
                Long tmp = Long.parseLong(line.substring("TimeStamp: ".length()));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                TimeStamp = simpleDateFormat.format(new Date(Long.parseLong(String.valueOf(tmp))));
            }
            else if(i==4){
                mp.Readmap(f.getPath()+line.substring("MapName: ".length()));
            }
            i++;
        }
        for(int i1=0;i1<5;i1++){
            All_image.addFileToCache(f.getPath()+"/"+imgname[i],imgname[i].replace(".png",""));
        }
    }

}
