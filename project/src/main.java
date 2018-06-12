import GUI.Start;
import sound.playbgm;

public class main {

	public static void main(String[] args) {
		Start pro1 = new Start();
		pro1.setPriority(1);  //優先權設定
		playbgm pro2 = new playbgm();
		pro2.setPriority(2);
		pro1.start();
		pro2.start();
	}

}
