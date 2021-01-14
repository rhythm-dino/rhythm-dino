package dino.main;

public class SettingsStorge {
    //TODO: use XML or JSON

    // Default Settings
    private int dinoSpeed = 5; //px
    private int obsSpeed = 1; //px
    private int dinoDisToLeft = 350; //px
    private String dinoImagePath; //TODO
    private String dino2ImagePath; //TODO
    private String[] obstacleImagePaths; //TODO

    public int getSpeed() {
        return obsSpeed;
    }

    public int getDinoDisToLeft() {
        return dinoDisToLeft;
    }

    public int getDinoSpeed() {
        return dinoSpeed;
    }

    public String getDinoImagePath() {
        return dinoImagePath;
    }

    public String[] getObstacleImagePaths() {
        return obstacleImagePaths;
    }
}
