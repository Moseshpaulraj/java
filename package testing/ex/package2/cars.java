package package2;
import package1.*; 
public class cars extends Car{    
	public static void main(String[] args) {
        	cars myCar = new cars();
		myCar.company="tesla";
		myCar.model="modelx";

       		System.out.println("Car Details:");
        	myCar.displayDetails();

        	System.out.println("\nCar Actions:");
        	myCar.start();
	}
}