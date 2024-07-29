import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

class AccountCreation{
	
	static int pin = 0 ;
	static String name = "";
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
			}
			System.out.print("Enter DOB : ");
			String dob = scanner.nextLine();
			boolean isDob=Verification.isDob(dob);
			if(!isDob){
				continue ;
			}
			System.out.print("Enter Location : ");
			String location = scanner.nextLine();
			Verification.isLocation(location);
			if(!isDob){
				System.out.println("Enter valid Date Of Birth...");
				continue ;
			}else{
				step2 = true ;
				break ;
			}
		}
		while(step2){
			System.out.print("CREATE A PIN : ");
			String pin1 = scanner.next();
			boolean isValidPin = Verification.isValidPin(pin1);
			if(!isValidPin){
				System.out.println("ENTER A VALID 4 DIGIT PIN..");
				continue ;
			}else{
				System.out.print("RE-ENTER YOUR PIN : ");
				String pin2 = scanner.next();
				if(pin1.equals(pin2)){
					step2 = false;
					pin = Integer.parseInt(pin1);
					try{
						String str = "INSERT INTO accounts(pin,username,balance)VALUES(?,?,?)RETURNING account_no;";
						PreparedStatement ps = connection.prepareStatement(str);
						ps.setInt(1,pin);
						ps.setString(2,name);
						ps.setDouble(3,balance);
						ResultSet rs=ps.executeQuery();
						if(rs.next()){
							int accountNo = rs.getInt("account_no"); 
							System.out.println("\nACCOUNT CREATED SUCCESSFULLY !");
							System.out.println("--------------------------------");
							System.out.println("your Account Number : " + accountNo);
							System.out.println("--------------------------------");
						}else{
							System.out.println("Failed !");
						}
						
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