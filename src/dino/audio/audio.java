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
//由于技术水平不足，使用ffmpeg将.mp3转换为.wav再播放
public class audio{
    private Clip c;
    private File f;
    private AudioInputStream ais;
    private long pause_msec;
    public void Convert_mp3_to_wav(String mp3local,String wavLocal) throws Exception{
        Runtime.getRuntime().exec("ffplay -i "+mp3local+" -f wav "+wavLocal);
    }
    public void play(String musicPath) throws Exception{
        if(musicPath.contains(".mp3")){

        }
        else if(musicPath.contains(".wav")){

        }
    }
    private void play_wav(String wavPath) throws Exception{
        try {
            f=new File(wavPath);
            ais=AudioSystem.getAudioInputStream(f);
            c=AudioSystem.getClip();
            c.open(ais);
            c.start();
            c.loop(Clip.LOOP_CONTINUOUSLY);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void pause() throws Exception{
        pause_msec=c.getMicrosecondLength();
        c.stop();
    }
    public void unpause() throws Exception{
        c.setMicrosecondPosition(pause_msec);
        c.start();
    }
    public void Reset() throws Exception{
        c.setMicrosecondPosition(0);
        c.start();
    }

}