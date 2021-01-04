package dino.audio;
import dino.extension.audioException;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.net.URI;
//由于技术水平不足，使用ffmpeg将.mp3转换为.wav再播放
public class audio{
    private Clip c;
    private File f;
    private AudioInputStream ais;
    private long pause_msec;
    private Boolean istmp=false;
    private String tmplocal=System.getProperty("user.dir")+"\\tmp\\poster.wav";
    public void Convert_mp3_to_wav(String mp3local,String wavLocal) throws Exception{
        Runtime.getRuntime().exec("ffplay -i "+mp3local+" -f wav "+wavLocal);
    }
    public void play(String musicPath) throws Exception{
        if(musicPath.contains(".mp3")){
            Convert_mp3_to_wav(musicPath,tmplocal);
            istmp=true;
            play_wav(tmplocal);
        }
        else if(musicPath.contains(".wav")){
            play_wav(musicPath);
        }
        else{
            throw new audioException("This file does not contain mp3 or wav!");
        }
    }
    private void play_wav(String wavPath) throws Exception{
        try {
            f=new File(wavPath);
            ais=AudioSystem.getAudioInputStream(f);
            c=AudioSystem.getClip();
            c.open(ais);
            c.loop(Clip.LOOP_CONTINUOUSLY);
            c.start();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void pause() throws Exception{
        pause_msec=c.getMicrosecondPosition();
        c.stop();
    }
    public void unpause() throws Exception{
        c.setMicrosecondPosition(pause_msec);
        c.loop(Clip.LOOP_CONTINUOUSLY);
        c.start();
    }
    public void reset() throws Exception{
        c.setMicrosecondPosition(0);
        c.loop(Clip.LOOP_CONTINUOUSLY);
        c.start();

    }
    public void close() throws Exception{
        c.close();
        f=null;
        ais=null;
        pause_msec=0;
        System.gc();
        if(istmp){
            if(! (new File(tmplocal).delete()) ){
                throw new audioException("Error: Cannot delete tmp Files!");
            }
        }
        istmp=false;
        System.gc();
    }
}