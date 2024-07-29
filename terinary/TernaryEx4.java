public class TernaryEx4{
	public static void main(String[] args){
		boolean isCar = false ;
		Vehicle myVehicle = (isCar) ? new Car() : new Bike () ;
		myVehicle.startEngine();
	}
}

public class Vehicle{
	public void startEngine(){
		System.out.println("Starting The Engine...");
	}	
}

public class Car extends Vehicle {
	@Override
	public void startEngine(){
		System.out.println("Starting Car Engine...");
	}
}

public class Bike extends Vehicle {
	@Override
	public void startEngine(){
		System.out.println("Starting Bike Engine...");
	}
}
