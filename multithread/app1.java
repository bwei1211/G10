package multithread;

public class app1 {
	public static void main(String[] args){
		Runner runner1 = new Runner();
		runner.start();
	}
}

class Runner extends Thread{
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