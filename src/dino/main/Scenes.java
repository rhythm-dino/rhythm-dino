package dino.main;

import dino.extension.ImageShower;
import dino.extension.KeyboardPanel;
import dino.extension.MoveThread;
import dino.extension.position;

import javax.swing.*;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Scenes extends JFrame {
    private ImageShower imgshow = new ImageShower();
    public static SettingsStorge settings = Main.getSettings();
    private Dinor dinor = new Dinor("/disk01/resource/silk/1.png", this.imgshow); //TODO: ImagePath, height.
    private Obstacle obs = new Obstacle("/disk01/resource/silk/2.png", 20, this.imgshow, new position(700, 500));
    private KeyboardPanel keyboardPanel = new KeyboardPanel(this.dinor, this);

//    public Scenes(String[] backgrounds) {
//        this.backgrounds = backgrounds;
//    } TODO

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.SOURCE)
    public @interface SCENESPLAY {
    }


    private String[] backgrounds; //TODO

    @SCENESPLAY
    public void play(/*JFrame frm*/) {
        add(keyboardPanel);
        keyboardPanel.setFocusable(true);

        dinor.display(new position(settings.getDinoDisToLeft()-200,500),this);
        obs.display(new position(700, 500), this, "obs");
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MoveThread moveThread = new MoveThread(obs, settings.getSpeed(), this, dinor);
        Thread tMove = new Thread(moveThread);
        tMove.start();
//        while(true) {
//            dinor.jump("dino", 5, this);
//        }
    }
}
