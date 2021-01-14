package dino.main;

import dino.extension.ImageShower;
import dino.extension.KeyboardPanel;
import dino.extension.MoveThread;
import dino.extension.position;

import javax.swing.*;

public class Scenes extends JFrame {
    private ImageShower imgshow = new ImageShower();
    private Dinor dinor = new Dinor("/disk01/resource/silk/1.png", this.imgshow);
    private Obstacle obs = new Obstacle("/disk01/resource/silk/2.png", 20, this.imgshow, new position(700, 500));
    private KeyboardPanel keyboardPanel = new KeyboardPanel(this.dinor, this);

    private String[] backgrounds; //TODO
    public void play(/*JFrame frm*/) {
        add(keyboardPanel);
        keyboardPanel.setFocusable(true);
        dinor.display(new position(100,800),this);
        obs.display(new position(700, 500), this, "obs");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MoveThread moveThread = new MoveThread(obs, 5, this);
        Thread tMove = new Thread(moveThread);
        tMove.start();
//        while(true) {
//            dinor.jump("dino", 5, this);
//        }
    }
}
