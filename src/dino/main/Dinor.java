package dino.main;

import dino.extension.position;
import dino.extension.*;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class Dinor extends AbstractEntity{
    private String imagePath;   // gif
    private ImageShower imageShower = new ImageShower();

    @Override
    public void display(position p, JFrame frame) {
        imageShower.addFileToCache("/disk01/resource/silk/1.png", "dino");
        imageShower.displayImage("dino",frame, p, 200, 300);
    }

    @Override
    public void jump(String name, int speed, JFrame frame) {
        for(int i=1;i<=90;i++) {
            imageShower.moveImageUp("dino", speed, frame);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(90);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=1;i<=90;i++) {
            imageShower.moveImageUp("dino", -speed, frame);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
