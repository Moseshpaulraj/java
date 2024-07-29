public class MultiEx2{

	public static void main(String[] args){
		for(int i=0;i<5;i++){
		Multithread mt = new Multithread();
		Thread myThread = new Thread(mt);
		myThread.start();
	/*	try{
		myThread.sleep(1000);}
		catch(Exception e){System.out.println("error");}*/
		}  
	}
}


public class Multithread implements Runnable{
	public void run(){
			System.out.println("checkin.... form thread"+Thread.currentThread().getName());
			System.out.println("working..... form thread"+Thread.currentThread().getName());
			System.out.println("checkout...... form thread"+Thread.currentThread().getName());
	}
}