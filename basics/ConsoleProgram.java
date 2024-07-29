import java.util.Scanner;

public class ConsoleProgram {
    // Constructor
    public ConsoleProgram() {
        start(); // Start the program
    }

    // Method to start the program
    public void start() {
        System.out.println("Welcome to the Console Program!");
        System.out.println("Please enter your name:");

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        greetUser(name); // Greet the user
        scanner.close(); // Close the scanner
    }

    // Method to greet the user
    public void greetUser(String name) {
        System.out.println("Hello, " + name + "! Welcome to the program.");
    }
}