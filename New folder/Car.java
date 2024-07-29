class Car{

	String company ;
	String model ;
	String color;
	double price ;
	
	public void start(){
		System.out.println("Car started");
	}
	public void accelerate(){
		System.out.println("Car Moving");
	}
	public void stop(){
		System.out.println("Car stoped");
	}
	
	public static void main(String[] args){
		Car myCar = new Car();
		myCar.company = "tesla" ;
		myCar.model = "X4" ;
		myCar.color = "black" ;
		myCar.price = 1000000.00 ;
		System.out.println(myCar.company);
		System.out.println(myCar.model);
		System.out.println(myCar.color);
		System.out.println(myCar.price);
		
		myCar.start();
		myCar.accelerate();
		myCar.stop();
	}
}