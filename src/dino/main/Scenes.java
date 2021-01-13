package dino.main;

import dino.extension.ImageShower;
import dino.extension.position;

import javax.swing.*;

public class Scenes {
    private ImageShower imgshow = new ImageShower();
    private Dinor dinor = new Dinor("/disk01/resource/silk/1.png", this.imgshow);
    private Obstacle obs = new Obstacle("/disk01/resource/silk/2.png", 20, this.imgshow);
    public void play(JFrame frm) {
        dinor.display(new position(100,800),frm);
        obs.display(new position(700, 500), frm, "obs");
        frm.pack();
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true) {
            dinor.jump("dino", 5, frm);
            obs.beCloserToDino(5, frm);
        }
    }
}
