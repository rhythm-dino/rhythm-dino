package dino.main;

import dino.extension.position;

import javax.swing.*;

public class Scenes {
    private Dinor dinor = new Dinor("/disk01/resource/silk/1.png");
    public void play(JFrame frm) {
        dinor.display(new position(100,800),frm);
        frm.pack();
        frm.setVisible(true);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        while(true) {
            dinor.jump("dino", 5, frm);
        }
    }
}
