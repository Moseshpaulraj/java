public class Synchronized{
	public static void main(String[] args){
	
		Counter count = new Counter();
		
		Thread team1 = new Thread(new Team(count));
		Thread team2 = new Thread(new Team(count));

		team1.start();
		team2.start();

		try{
			team1.join();
			team2.join();	
		}
		catch(Exception e){
			System.out.println("its Error bro 😂");
		}   

		System.out.println(count.totalCount);
		
	}
	
}

public class Counter{
	int totalCount = 0 ;
	public synchronized void increment(){
		totalCount++;
	}
}

public class Team implements Runnable{
	
	Counter count;
	
	public void run(){
		for(int i=0;i<1000;i++){
			count.increment();
		}
	}
	public Team(Counter count){
		this.count = count ;
	}
}