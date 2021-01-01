package dino.audio;
import java.io.*;
import javax.media.*;
class audioException extends Exception{
    audioException(String errMesage){
        super(errMesage);
    }
}
public class audio {

    private String address;
    private Player player;
    public audio(String a){
        this.address = a;
    }
    public void start() throws IOException,NoPlayerException{
        File file=new File(address);
        player = Manager.createPlayer(file.toURL());
        player.start();
    }
    public void pause() throws NoPlayerException{
        player.stop();
    }
    public void unpause() throws NoPlayerException{
        player.start();
    }
}
