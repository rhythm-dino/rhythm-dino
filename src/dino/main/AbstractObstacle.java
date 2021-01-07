package dino.main;

import dino.extension.position;

import javax.swing.*;

public abstract class AbstractObstacle {
    private String imagePath; //gif
    public abstract void display(position p, JFrame frame, String entName);
    public abstract boolean canPass(Dinor dino);
}
