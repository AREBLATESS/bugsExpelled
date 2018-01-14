
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class Main {
    public static void main (String args[]){
        MainFrame mFrm = new MainFrame();
        mFrm.setVisible(true);
        //音樂CODE 限用wav類音樂檔
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("BGM1.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            Thread.sleep(10000);
        }
        catch (Exception music){
            System.out.print(music);
        }
    }
}