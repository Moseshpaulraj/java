public class Car {
    String company;
    String model;
    int year;
    double price;

    // Constructor
    public Car(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    // Method to display car details
    public void displayDetails() {
        System.out.println("Make: " + make);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Price: $" + price);
    }

    // Method to start the car
    public void start() {
        System.out.println("Starting the " + make + " " + model);
    }

    // Method to stop the car
    public void stop() {
        System.out.println("Stopping the " + make + " " + model);
    }

    // Method to accelerate the car
    public void accelerate() {
        System.out.println("Accelerating the " + make + " " + model);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Creating an instance of Car class
        Car myCar = new Car("Toyota", "Camry", 2022, 25000.00);

        // Displaying details of the car
        System.out.println("Car Details:");
        myCar.displayDetails();
        
        // Performing car actions
        System.out.println("\nCar Actions:");
        myCar.start();
        myCar.accelerate();
        myCar.brake();
        myCar.stop();
    }
}
