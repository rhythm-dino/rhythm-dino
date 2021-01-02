package dino.main;
import javax.swing.*;
import dino.beatmap.*;
import dino.extension.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import dino.audio.*;
public class Main {
    public static void imgTest() {
        JFrame frame = new JFrame("imgTest");
        ImageShower imageShower = new ImageShower();
        imageShower.addFileToCache("/disk01/resource/silk/1.png", "atest");
        imageShower.displayImage("atest",frame,new position(500, 600), 600, 600);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void adoTest() throws Exception {
        audio ado = new audio("/home/amiriox/Music/CloudMusic/findthepieces.mp3");
        ado.play();
        Thread.sleep(9000);
        ado.pause();
        Thread.sleep(50000);
        ado.play();
    }
    public static void main(String[] args) throws Exception {
//        imgTest();
        adoTest();
        Thread.sleep(10000000);
    }
}


