class Location{
	
	static String[] route1 ={"chennai","280","salem","170","coimbatore","200","madurai","150","tirunelveli","100","thoothukudi","300","thanjavur","180","puducherry","150"};
	static String[] route2 ={"tirunelveli","150","madurai","200","coimbatore","170","salem","345","chennai","150","puducherry","180","thanjavur","320","thoothukudi","100"};
	
	public static void displayMap(){
		
		System.out.println("\n                           _____*Chennai");
		System.out.println("                       ___/             |");
		System.out.println("                     _/                 |");
		System.out.println("                Salem*              *Puducherry");
		System.out.println("                  /                   /");
		System.out.println("             ___/                    /");
		System.out.println("     Coimbatore*                *Thanjavur");
		System.out.println("             \\                     /");
		System.out.println("              \\__                 /");
		System.out.println("                 \\                |");
		System.out.println("               Madurai*           |");
		System.out.println("                   |             /");
		System.out.println("                    \\           /");
		System.out.println("                     \\     *Thoothukudi");
		System.out.println("              Tirunelveli*    /");
		System.out.println("                       \\_ _ _/\n");
	
	} 
	
	public static int calculateDistance(String Location1,String Location2){
		
		int distance1 = tripDistance(Location1,Location2,route1);
		int distance2 = tripDistance(Location1,Location2,route2); 
		int Distance = distance1<=distance2 ? distance1 : distance2 ;
		return Distance ;
		
	}
	
	public static int tripDistance(String pickupLocation,String dropLocation,String[] arr){
		int pickupIndex=0 ,dropIndex=0 ,distance=0 ;
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(pickupLocation)){
				pickupIndex = i ;
			}else if(arr[i].equals(dropLocation)){
				dropIndex = i ;
			}
		}
		if(pickupIndex<dropIndex){
			for(int i=pickupIndex+2;i<=dropIndex;i+=2){
				distance += Integer.parseInt(arr[i-1]);
			}
		}else{
			for(int i=dropIndex+2;i<=pickupIndex;i+=2){
				distance += Integer.parseInt(arr[i-1]);
			}
		}
		return distance ;
	}
	
	public static int pickupDistance(String currentLocation,String pickupLocation,String[] arr){
		
		int currentIndex=0 ,pickupIndex=0 ,distance=0 ;
		for(int i=0;i<arr.length;i++){
			if(arr[i].equals(currentLocation)){
				currentIndex = i ;
			}else if(arr[i].equals(pickupLocation)){
				pickupIndex = i ;
			}
		}
		if(currentIndex<pickupIndex){
			for(int i=currentIndex;i<=pickupIndex;i+=2){
				distance += Integer.parseInt(arr[i-1]);
			}
		}else{
			for(int i=pickupIndex;i<=currentIndex;i+=2){
				distance += Integer.parseInt(arr[i-1]);
			}
		}
		return distance ;
	}
}