package sound;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Sound extends Thread {
	Player player;
	FileInputStream fis;
	BufferedInputStream bis;
	
	String path = "src/sounds/sound1.mp3";
	
	public Sound() {
		try {
			fis = new FileInputStream(path);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println("Problem playing file " + path);
			System.out.println(e);
		}
	}
	
	public void run() {
		try {
			player.play();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
