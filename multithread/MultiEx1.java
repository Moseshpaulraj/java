public class MultiEx1{

	public static void main(String[] args){
		for(int i=0;i<5;i++){
		Multithread myThread = new Multithread();
		myThread.start();
		}
	}
}


public class Multithread extends Thread{
	public void run(){
			System.out.println("checkin.... form thread"+Multithread.currentThread().getName());
			System.out.println("working..... form thread"+Multithread.currentThread().getName());
			System.out.println("checkout...... form thread"+Multithread.currentThread().getName());
	}
}

