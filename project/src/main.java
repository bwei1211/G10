import GUI.Start;
import sound.playbgm;

public class main {

	public static void main(String[] args) {
		Start pro1 = new Start();
		pro1.setPriority(1);  //�u���v �Ʀr�V�j�V��
		playbgm pro2 = new playbgm();
		pro2.setPriority(2);
		pro1.start();
		pro2.start();
	}

}
