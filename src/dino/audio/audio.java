package dino.audio;
import java.io.*;
//由于技术水平不足，只好用ffplay播放
class audioThread implements Runnable{
    private String t;
    audioThread(String s){
        this.t=s;
    }
    @Override
    public void run() {
        try{
            Runtime.getRuntime().exec(t);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
public class audioException extends Exception{
    audioException(String a){
        super(a);
    }
}
public class audio{
    private Boolean isplay=false;
    private String music_path;
    private Thread t;
    public audio(String s){
        this.music_path=s;
    }
    audio(){

    }
    public void setMusic_path(String music_path) {
        this.music_path = music_path;
    }
    public void play() throws audioException{
        if(!music_path.contains(".mp3")){
            throw new audioException("Error: Not a mp3 file!");
        }
        if(isplay){
            throw new audioException("Error: please close another audio.");
        }
        Runnable r=new audioThread("ffplay -i -nodisp "+music_path);
        t=new Thread(r);
        isplay=true;
        t.start();
    }
    public void pause() throws Exception{
        if(!isplay){
            throw new audioException("Error: You can't pause the audio before start it");
        }
        t.wait();
    }
    public void unpause(){
        t.notifyAll();
    }
    public void close(){
        t.interrupt();
        isplay=false;
    }
}
