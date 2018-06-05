package multithread;

public class app2 {
	public static void main(String[] args){
		Runner run1 = new Thread(new Runner2());
		run1.start();
		Runner run2 = new Thread(new Runner2());
		run2.start();
	}
}

class Runner2 extends Runnable{
	public void run(){
		for(int i=1;i<+10;i++){
			System.out.print("LUL "+i);
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}