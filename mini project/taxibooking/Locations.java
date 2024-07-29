import java.util.*;
class Locations{
	
	static String[] route = {"kanniyakumari","tirunelveli","madurai","salem","chennai"};
	
	public static void routes(){
		System.out.println("------------------------------");
		for(int i=0;i<route.length;i++){
			System.out.println( "         "+(i+1)+"->"+route[i]);
		}
		System.out.println("------------------------------");
	}
	
	public static int sourcetime(int pickupPoint,int currentSpot){
		int hrs = 0 ;
		if(pickupPoint<currentSpot){
			for(int i=pickupPoint;i<currentSpot;i++){
				hrs++;
			}
		}
		else
		{
			for(int i=currentSpot;i<pickupPoint;i++){
				hrs++;
			}
		}	
		return hrs;
	}
	public static int tripdistance(int pickupPoint,int droppoint){
		int hrs = 0 ;
		if(pickupPoint<droppoint){
			for(int i=pickupPoint;i<droppoint;i++){
				hrs++;
			}
		}
		else
		{
			for(int i=droppoint;i<pickupPoint;i++){
				hrs++;
			}
		}
		hrs = hrs*15;
		return hrs;
	}
}