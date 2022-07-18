package main.sound;

import java.net.URL;
import java.util.Hashtable;

public class Sounds {
    
    public Hashtable<String, URL> soundsDict = new Hashtable<String, URL>();

    public Sounds() {

        soundsDict.put("shoot1", getClass().getResource("..\\..\\res\\sounds\\entity\\player\\shoot1.wav"));
        soundsDict.put("shoot2", getClass().getResource("..\\..\\res\\sounds\\entity\\player\\shoot2.wav"));

    }

}
