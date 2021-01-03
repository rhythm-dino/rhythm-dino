package dino.main;

import dino.extension.position;

import javax.swing.*;
import java.util.Objects;
import java.util.jar.JarFile;

public abstract class AbstractEntity {
    private String imagePath;
    public abstract void display(position p, JFrame frame);
    public abstract void jump(String name, int speed, JFrame frame);
}
