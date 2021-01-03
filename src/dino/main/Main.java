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

    }
    public static void main(String[] args) throws Exception {
<<<<<<< HEAD
//        imgTest();
//        adoTest();
//        Thread.sleep(10000000);
        Scenes scenes = new Scenes();
        JFrame frame = new JFrame("dinor test");
        scenes.play(frame);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
=======
        adoTest();
>>>>>>> 93ed215 (...)
    }
}


