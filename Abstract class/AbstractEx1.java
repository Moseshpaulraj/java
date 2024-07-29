public class AbstractEx1
{
	public static void main(String[] args) 
		{

		Vehicle car = new Car();
		car.start(); 
		Vehicle bike = new Bike();
		bike.start();
	}
}

abstract class Vehicle{

	abstract void start();
}

class Car extends Vehicle {
	
	public void start() 
	{
		System.out.println("Starting Car");
	}
}

class Bike extends Vehicle 
{
	public void start(){
		System.out.println("Starting Bike");
	}
}

