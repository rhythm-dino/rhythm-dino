package dino.extension;

import dino.main.Dinor;
import dino.main.Scenes;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardPanel extends JPanel {
    static Dinor dino;
    public KeyboardPanel(Dinor _dino, JFrame frm) {
        this.dino = _dino;
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP : {
                        System.out.println(100); //TODO
                        if(!dino.isInAir) {
                            MoveThread tMove = new MoveThread(dino, Scenes.settings.getDinoSpeed(), frm);
                            Thread tm = new Thread(tMove);
                            tm.start();
                        }
                        break;
                    }
                    case KeyEvent.VK_DOWN: {
                        System.out.println(2); //TODO
                        break;
                    }
                    default: break;
                }
            }
        });
    }
}