package dino.main;
import javax.swing.*;
import dino.beatmap.*;
import dino.extension.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import dino.audio.*;
public class Main {

    public static void test() throws Exception{
        audio a=new audio();
        System.out.println("Start to play!");
        a.play("C:\\x.wav");
        Thread.sleep(9000);
        System.out.println("Start to pause!");

        System.out.println("start to resume!");
        a.unpause();
        Thread.sleep(2000);
        System.out.println("start to reset !");
        a.reset();
        Thread.sleep(9000);
        System.out.println("Program close!");
        a.close();
    }

    public static void main(String[] args) throws Exception {
       test();


    }
}


