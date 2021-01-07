package dino.main;

import dino.extension.ImageShower;
import dino.extension.position;

import javax.swing.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Obstacle extends AbstractObstacle{
    private String imagePath;
    private int obsHeight = 0;
    public int distanceToLeft;
    private String tName;
    private ImageShower imageShower = new ImageShower();
    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    Lock r = rwl.readLock();
    Lock w = rwl.writeLock();

    public Obstacle(String path, int height) {
        obsHeight = height;
        imagePath = path;
    }

    @Override
    public void display(position p, JFrame frame, String entName) {
        imageShower.addFileToCache(imagePath, entName);
        imageShower.displayImage("dino",frame, p, 200, 300);
    }

    public void beCloserToDino(int speed, JFrame frame) {
        for(int i=1;i<=90;i++) {
            imageShower.moveImageUp(tName, speed, frame);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                w.lock();
                distanceToLeft -= speed;
                w.unlock();
            }
        }
    }

    @Override
    public boolean canPass(Dinor dino) {
        return dino.jumpHeight >= obsHeight;
    }
}
