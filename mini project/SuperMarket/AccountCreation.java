import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner; 

class AccountCreation{
	
	static int pin = 0 ;
	static String name,phone,password;
	static boolean step2 = false;

	public static void createAccount(Connection connection){
		double balance =  0 ;
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("\nEnter Your Name : ");
			String username = scanner.nextLine();
			boolean isName = Verification.isName(username);
			if(!isName){
				System.out.println("Enter valid Name...");
				continue ;
			}
			name = username;
			System.out.print("Enter Phone no : ");
			String phone = scanner.nextLine();
			boolean isPhoneNo = Verification.isPhoneNo(phone);
			if(!isPhoneNo){
			System.out.println("Enter valid Phone no...");
				continue ;
			}else{
				step2 = true ;
			}
			break;
		}
		while(step2){
			System.out.print("CREATE A PASSWORD : ");
			String password = scanner.next();
			boolean isValidPassword = Verification.checkPassword(password);
			if(!isValidPassword){
				System.out.println("ENTER A VALID PASSWORD");
				continue ;
			}else{
				System.out.print("RE-ENTER YOUR PASSWORD : ");
				String pw = scanner.next();
				if(password.equals(pw)){
					step2 = false;
					try{
						String str = "INSERT INTO users(username,phone,password)VALUES(?,?,?);";
						PreparedStatement ps = connection.prepareStatement(str);
						ps.setString(1,name);
						ps.setString(2,phone);
						ps.setString(3,password);
						ps.executeUpdate();
							System.out.println("\nACCOUNT CREATED SUCCESSFULLY !");					
					}catch(Exception e){
						e.printStackTrace();
					}
				}else{
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println(" WRONG PASSWORD !!!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
				}
			}
		}
	}
}