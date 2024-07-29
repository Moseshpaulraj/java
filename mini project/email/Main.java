import java.util.Scanner;
public class Main {
	public static final String FILENAME = "userData.txt";
	
    public static void main(String[] args) {
		Zmail.loadUserData();
        Scanner scanner = new Scanner(System.in);
	
        while (true){
            System.out.println("\n1. Create New Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("\nEnter your Choice : ");
            byte choice = scanner.nextByte();
            switch (choice){
               case 1:
                    AccountCreation.createAccount();
                    break ;
               case 2:
					if(Zmail.login()){
				a:
					while(true){
					System.out.println("\n1. compose");
					System.out.println("2. sendedMessagese");
					System.out.println("3. receivedMessag");
					System.out.println("4. logout");
					System.out.print("\nEnter your Choice : ");
					byte choice2 = scanner.nextByte();
					switch (choice2){
					case 1:
						Zmail.sendMail();
						break;
					case 2:
						Zmail.displayMessages(Zmail.users.get(Zmail.currentUser).getSentMessages(),"SENT");
						break;
					case 3:
						Zmail.displayMessages(Zmail.users.get(Zmail.currentUser).getReceivedMessages(),"RECEIVED");
						break;
					case 4:
						Zmail.currentUser = null;
						System.out.println("Logged out successfully!");
						break a; 
					default:
						System.out.println("Invalid choice!");
					}
				}
			}
			break;
			case 3:
			Zmail.saveUserData();
			System.out.println("\n===================");
			System.out.println("HAVE A NICE DAY!!");
			System.out.println("===================");
			System.exit(0);
			break;
            default:
            System.out.println("Invalid choice!");
            }
        } 
    }
}