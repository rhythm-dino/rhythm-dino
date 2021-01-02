package dino.main;
import javax.swing.*;
import dino.beatmap.*;
import dino.extension.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import dino.audio.*;
public class Main {
    public static void main(String[] args) throws audioException {
        audio ado = new audio("/home/amiriox/Music/CloudMusic/findthepieces.mp3");
        ado.play();
    }
}


