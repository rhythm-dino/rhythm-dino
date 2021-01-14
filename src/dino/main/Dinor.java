package dino.main;

import dino.extension.position;
import dino.extension.*;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Dinor extends AbstractEntity{
    private String imagePath;   // gif
    private ImageShower imageShower = new ImageShower();
    public int jumpHeight = 0;  // px
    public boolean isInAir = false;
    // this is a buggy code
    // if i change this selfPosition object
    // the image will be moved
    // maybe devil did that!
    // oh, i know
    // this.position = p
    // reference too bad!
    public position selfPosition; //TODO

    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    Lock r = rwl.readLock();
    Lock w = rwl.writeLock();

    Dinor(String imgPath, ImageShower imgs) {
        imagePath = imgPath;
        imageShower = imgs;
    }
    @Override
    public void display(position p, JFrame frame) {
        imageShower.addFileToCache(imagePath, "dino");
        imageShower.displayImage("dino",frame, p, 200, 300);
        this.selfPosition = new position(p.getX(), p.getY());
    }

    @Override
    public void jump(String name, int speed, JFrame frame) {
        isInAir=true;
        System.out.println("log: jump for" + speed);
        for(int i=1;i<=90;i++) {
            imageShower.moveImageUp(name, speed, frame);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                w.lock();
                jumpHeight += speed;
                this.selfPosition.addY(-speed);
                System.out.println(this.selfPosition.getY());
                w.unlock();
            }
        }
        try {
            Thread.sleep(90);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i=1;i<=90;i++) {
            imageShower.moveImageUp(name, -speed, frame);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                w.lock();
                jumpHeight -= speed;
                this.selfPosition.addY(speed);
                System.out.println(this.selfPosition.getY());
                w.unlock();
            }
        }
        isInAir=false;
    }
}
