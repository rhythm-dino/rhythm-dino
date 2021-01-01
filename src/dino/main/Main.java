package dino.main;
import javax.swing.*;
import dino.beatmap.*;
import dino.extension.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
public class Main {
    public static void main(String[] args) {


    }
    public static void audioTest() {
        audio player = new audio("/home/amiriox/Music/CloudMusic/findthepieces.mp3");
        player.play();
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        imgPalTest();
        Process process = Runtime.getRuntime().exec("vlc /home/amiriox/Music/CloudMusic/song.wav");
    }
}


