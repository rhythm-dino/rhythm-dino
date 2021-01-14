package dino.main;

public class Main {
    public static SettingsStorge getSettings() {
        // this is NOT a test method.
        // DON'T remove it.
        //TODO
        // System.in....
        return new SettingsStorge();
    }
    public static void main(String[] args) throws Exception{
        System.out.println("Hello World!");
        Scenes scenes = new Scenes();
        scenes.play();
    }
}


