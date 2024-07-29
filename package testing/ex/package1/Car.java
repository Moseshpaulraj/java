package package1;
public class Car {
    private String company;
    public String model;
    public void displayDetails() {
        System.out.println("company: " + company);
        System.out.println("Model: " + model);
    }
    protected void start() {
        System.out.println("Starting the " + company + " " + model);
    }
}
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