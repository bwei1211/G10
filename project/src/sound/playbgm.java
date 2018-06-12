package sound;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class playbgm extends Thread {
	public void run() {

		// System.out.println(System.getProperty("user.dir"));

		File bgm = new File("resources/sound/Wii-Mii_Theme.wav");
		
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
			FloatControl gainControl =  (FloatControl) BGM.getControl(FloatControl.Type.MASTER_GAIN);
				gainControl.setValue(-10.0f); //調整音量6.0206 ~ -80
			BGM.start();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}
