package dino.extension;

import dino.main.Dinor;
import dino.main.Obstacle;

import javax.swing.*;

public class MoveThread implements Runnable{
    Object ent;
    int speed;
    JFrame frm;
    Dinor _dino;
    public MoveThread(Obstacle obs, int spd, JFrame fm, Dinor dino) {
        this.ent = obs;
        this.frm = fm;
        this.speed = spd;
        _dino=dino;
    }
    public MoveThread(Dinor din, int spd, JFrame fm) {
        this.ent = din;
        this.speed =spd;
        this.frm = fm;
    }
    @Override
    public void run() {
        if(ent instanceof Dinor)
            ((Dinor) ent).jump("dino", speed, frm);

        else if(ent instanceof Obstacle)
            ((Obstacle) ent).beCloserToDino(speed, frm, _dino);
    }
}
