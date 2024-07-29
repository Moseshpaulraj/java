import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int pickupPoint;

    public static void main(String[] args) {
        List<Taxi> taxis = Taxi.createTaxis(4);
        Scanner scanner = new Scanner(System.in);
        try {
            int id = 1;
            while (true) {
                System.out.println("\n1 -> Book Taxi");
                System.out.println("2 -> Taxi details");
                System.out.println("3 -> Exit");
                System.out.print("\nEnter your Option: ");
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        int customerID = id;
                        Locations.routes();
                        System.out.print("Enter pickup point: ");
                        pickupPoint = scanner.nextInt() - 1;
                        Locations.routes();
                        System.out.print("Enter drop point: ");
                        int dropPoint = scanner.nextInt() - 1;
                        System.out.print("Enter pickup time (HHMM): ");
                        int pickupTime = scanner.nextInt();
                        if (pickupPoint == dropPoint) {
                            System.out.println("\nYour source and destination are the same. Please check again.");
                            break;
                        }
                        LocalDateTime pickupDateTime = LocalDateTime.now().withHour(pickupTime / 100).withMinute(pickupTime % 100);
                        List<Taxi> freeTaxis = Booking.getFreeTaxis(taxis, pickupDateTime, pickupPoint);
                        if (freeTaxis.isEmpty()) {
                            System.out.println("It's hard to reach you at the given time. Check taxi details for availability...");
                            break;
                        }
                        Booking.bookTaxi(id, pickupPoint, dropPoint, pickupDateTime, freeTaxis);
                        id++;
                        break;
                    case 2:
                        boolean backToMain = false;
                        while (!backToMain) {
                            System.out.println("\n1 -> Display details");
                            System.out.println("2 -> Taxi History");
                            System.out.println("3 -> Back");
                            System.out.print("\nEnter your Option: ");
                            int choice2 = scanner.nextInt();
                            switch (choice2) {
                                case 1:
                                    System.out.println("\n-------------------------------");
                                    for (Taxi t : taxis)
                                        t.printTaxiDetails();
                                    break;
                                case 2:
                                    while (true) {
                                        System.out.println("\n1 -> Taxi 1");
                                        System.out.println("2 -> Taxi 2");
                                        System.out.println("3 -> Taxi 3");
                                        System.out.println("4 -> Taxi 4");
                                        System.out.print("Enter your Option: ");
                                        int choice3 = scanner.nextInt();
                                        System.out.println("\n---------------------------------------------------------------------------------------");
                                        System.out.println("customerID     pickupPoint       dropPoint        pickupTime     dropTime     earning");
                                        Taxi t = taxis.get(choice3 - 1);
                                        for (String str : t.getTrips()) {
                                            System.out.println();
                                            System.out.println(str);
                                        }
                                        System.out.println("\n---------------------------------------------------------------------------------------");
                                        break;
                                    }
                                    break;
                                case 3:
                                    backToMain = true;
                                    break;
                                default:
                                    System.out.println("Enter a valid option!!!");
                                    break;
                            }
                        }
                        break;
                    case 3:
                        return;
                    default:
                        System.out.println("Enter a valid option!!!");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("> Enter valid input <");
        }
    }
}
