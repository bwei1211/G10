package sound;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class sound1 extends Thread {
	Player player;
	FileInputStream fis;
	BufferedInputStream bis;
	
	String path = "resources/sound/sound1.mp3";
	
	public sound1() {
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
