package dino.beatmap;

import java.io.*;
import java.util.List;
import dino.extension.mapException;
public class MapCore {
    Integer startsec;
    List<Integer> obstsec;
    List<Integer> longobstsec;//long obstaclesec
    List<Integer> dyobsec;
    public MapCore(){

    }
    public void Readmap(String map_path) throws IOException, mapException {
        InputStream is=new FileInputStream(map_path);
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"),512);
        for(String line=br.readLine();line!=null;line= br.readLine()){
            Dispatch(line);
        }
    }
    private void Dispatch(String args) throws mapException{
        if(args.startsWith("map start ")){//map start
            String tmp=args.substring(("map start ").length());
            startsec=Integer.parseInt(tmp);
        }
        else if(args.startsWith("set ")){//set
            String tmp=args.substring("set ".length());
            obstsec.add(Integer.parseInt(tmp));
            if(!unsame()){
                throw new mapException("Cannot place two obstacle in the same second!");
            }
            System.gc();
        }
        else if(args.startsWith("setlong ")){//setlong
            String tmp=args.substring("setlong ".length());
            longobstsec.add(Integer.parseInt(tmp));
            if(!unsame()){
                throw new mapException("Cannot place two obstacle in the same second!");
            }
            System.gc();
        }
        else if(args.startsWith("setdy ")){
            String tmp=args.substring("setdy ".length());
            dyobsec.add(Integer.parseInt(tmp));
            if(!unsame()){
                throw new mapException("Cannot place two obstacle in the same second!");
            }
            System.gc();
        }
    }
    private Boolean unsame(){
        Boolean tmp=true;
        int i=0;
        while(true){
            if(obstsec.contains(longobstsec.get(i))){
                tmp=false;
                break;
            }
            i++;
        }
        return tmp;
    }
}
