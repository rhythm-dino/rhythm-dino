package dino.beatmap;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.*;
import dino.extension.*;
class beatmapException extends Exception{
    beatmapException(String errmessage){
        super(errmessage);
    }
}
public class beatmap {
    private double stars;
    private String songs;
    private String configfile;
    private Map<String,Object> inifile;
    public beatmap(beatmap b){
        this.configfile=b.configfile;
        this.songs=b.songs;
        this.inifile=b.inifile;
        this.stars=b.stars;
    }
    public void Read_Beatmap(String bpath)
    {
        try {
            inifile=readini.readIni(bpath+"/config.ini");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof beatmap)) return false;
        beatmap beatmap = (beatmap) o;
        return Double.compare(beatmap.stars, stars) == 0 &&
                Objects.equals(songs, beatmap.songs) &&
                Objects.equals(configfile, beatmap.configfile) &&
                Objects.equals(inifile, beatmap.inifile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stars, songs, configfile, inifile);
    }
}
