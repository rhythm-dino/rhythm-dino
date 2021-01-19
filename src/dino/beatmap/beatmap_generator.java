package dino.beatmap;
import java.io.*;
import  dino.extension.*;
import java.util.*;
public class beatmap_generator {
    private Boolean skin = new Boolean(false);
    private String name,background,Author,map;
    private Double difficulty;
    private final String tmpdir = System.getProperty("user.dir") + "/tmp";
    private String dinoimage_path="",obstacleimage_path="",longobstacleimage_path="",dynamicobstacleimage_path="";
    protected final String[] allpath  = {
            tmpdir+"/Config.data",
            tmpdir+"/dino.png",
            tmpdir+"/bg.png",
            tmpdir+"/obstacle.png",
            tmpdir+"/long_obstacle.png",
            tmpdir+"/dynamic_obstacle.png",
            tmpdir+"/Map.map"
    };
    public beatmap_generator(String... inf) throws  beatmap_generator_Exception{
        if(inf.length != 4 && skin != false || inf.length != 9 && skin != true){
            throw new beatmap_generator_Exception("Error: the count of the arguments are not right!");
        }
        if(skin){
            name = inf[0];
            Author = inf[1];
            difficulty = Double.parseDouble(inf[2]);
            map = inf[3];
            background = inf[4];
            dinoimage_path = inf[5];
            obstacleimage_path = inf[6];
            longobstacleimage_path = inf[7];
            dynamicobstacleimage_path = inf[8];
        }
        else{
            name = inf[0];
            Author = inf[1];
            difficulty = Double.parseDouble(inf[2]);
            map = inf[4];
        }
    }
    public void isSkin(Boolean skin) {
        this.skin = skin;
    }
    private Boolean create_File(String File_Name) throws IOException {
        File f = new File(File_Name);
        return f.createNewFile();
    }
    private void Write_information(FileOutputStream fos) throws IOException {
        OutputStreamWriter osw =  new OutputStreamWriter(fos,"UTF-8");
        osw.write("Name: "+name+"\n"+"Author: "+Author+"\n"+"TimeStamp: "+new Long(Calendar.getInstance().getTimeInMillis()).toString()+"\n"+"MapName: "+map);
    }
    private Boolean move(String FilePath, String ansPath){
        File f = new File(FilePath);
        return f.renameTo(new File(ansPath));
    }
    public void Generate(String output_path) throws IOException {
        zip zp =new zip();
        create_File(allpath[0]);
        FileOutputStream fos = new FileOutputStream(new File(allpath[0]));
        Write_information(fos);
        move(dinoimage_path,allpath[1]);
        move(background,allpath[2]);
        move(obstacleimage_path,allpath[2]);
        move(longobstacleimage_path,allpath[3]);
        move(dynamicobstacleimage_path,allpath[4]);
        move(map,allpath[5]);
        zp.zipFiles(output_path,allpath);
    }
}
