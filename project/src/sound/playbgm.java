package sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class PlayBGM extends Thread {
	static FloatControl Ctrl;
	
	static Float volume = (float) -10.0;
	
	public void run() {

		// System.out.println(System.getProperty("user.dir"));

		File bgm = new File("src/sounds/Wii-Mii_Theme.wav");
		
		Clip BGM = null;
		try {
			BGM = AudioSystem.getClip();
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(bgm);
			BGM.open(inputStream);
		} catch (Exception e) {
			System.out.println("play sound error: " + e.getMessage() + " for " + bgm);
		}
		try {
			BGM.loop(MAX_PRIORITY);
			Ctrl =  (FloatControl) BGM.getControl(FloatControl.Type.MASTER_GAIN);
			Ctrl.setValue(volume); //音量6.0206 ~ -80  -40
			BGM.start();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	static public void setVolume() {
		
	}
	
	static public void CloseVolume() {
		Ctrl.setValue(-80);
	}
	
	static public void OpenVolume() {
		Ctrl.setValue(volume);
	}
}
