import java.util.Scanner;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
		
		Connection connection =null; 
		try{
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/bank","moses","54321"); 
		String str1 = "CREATE SEQUENCE IF NOT EXISTS account_no_seq START WITH 1000 INCREMENT BY 1";
		String str2 = "CREATE TABLE IF NOT EXISTS accounts(account_no INT DEFAULT nextval('account_no_seq')PRIMARY KEY, pin INT NOT NULL ,username VARCHAR(100) NOT NULL,balance DOUBLE PRECISION NOT NULL);";
		Statement statement = connection.createStatement();
		statement.executeUpdate(str1);
		statement.executeUpdate(str2);
        Scanner scanner = new Scanner(System.in);
	
        while (true){
            System.out.println("\n1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("\nEnter your Choice : ");
            int choice = scanner.nextInt();
            switch (choice){
               case 1:
                    AccountCreation.createAccount(connection);
                    break ;
               case 2:
					if(Verification.login(connection)){
						int account_no = Verification.account_num;
					a:
					while(true){
					System.out.println("\n1. Deposit Money");
					System.out.println("2. Withdraw Money");
					System.out.println("3. Check Balance");
					System.out.println("4. Transfer Money");
					System.out.println("5. Close Account");
					System.out.println("6. back");
					System.out.print("\nEnter your Choice : ");
					int choice2 = scanner.nextInt();
					switch (choice2){
					case 1:
					Banking.depositMoney(connection,account_no);
                    break;
					case 2:
					Banking.withdrawMoney(connection,account_no);
					break;
					case 3:
					Account.checkBalance(connection,account_no);
					break;
					case 4:
					Banking.transferMoney(connection,account_no);
					break;
					case 5:
					Account.closeAccount(connection,account_no);
					break; 
					case 6:
					break a; 
					default:
						System.out.println("Invalid choice!");
					}
				}
			}
			break;
			case 3:
			System.out.println("\n===================");
			System.out.println("HAVE A NICE DAY!!");
			System.out.println("===================");
			System.exit(0);
            default:
            System.out.println("Invalid choice!");
			break;
            }
        } 
		}catch(Exception e){e.printStackTrace();}
    }
}