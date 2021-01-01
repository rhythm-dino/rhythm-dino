package dino.main;

import dino.extension.position;

import java.util.Objects;

public abstract class AbstractEntity {
    private String imagePath;
    public abstract void display(position p);
}
