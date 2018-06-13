import GUI.Start;
import sound.PlayBGM;

public class Main {
	
	public static void main(String[] args) {
		Start pro1 = new Start();
		pro1.setPriority(1);  //優先權設定
		PlayBGM pro2 = new PlayBGM();
		pro2.setPriority(2);
		pro1.start();
		pro2.start();
	}

}
