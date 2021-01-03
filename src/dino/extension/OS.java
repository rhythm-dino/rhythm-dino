package dino.extension;
import java.lang.*;
public class OS {
    public OS(){

    }
    public String getOS(){
        return System.getProperty("os.name").toLowerCase().contains("win")?"Windows":System.getProperty("os.name").toLowerCase().contains("mac")?"MacOS":"Linux";
    }

}
