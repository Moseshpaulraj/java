import java.io.*;
import java.util.*; 

class AccountCreation{
	static boolean step2 = false;
	static String name,phone,dob,location,zmail,password;
	
	public static void createAccount(){
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.print("\nEnter Your Name : ");
			String username = scanner.nextLine();
			boolean isName = Verification.isName(username);
			if(!isName){
				System.out.println("Enter valid Name...");
				continue ;
			}else{
				name = username;
			}
			System.out.print("Enter Phone no : ");
			phone = scanner.nextLine();
			boolean isPhoneNo = Verification.isPhoneNo(phone);
			if(!isPhoneNo){
			System.out.println("Enter valid Phone no...");
			continue ;
			}
			System.out.print("Enter DOB : ");
			dob = scanner.nextLine();
			boolean isDob=Verification.isDob(dob);
			if(!isDob){
				continue ;
			}
			System.out.print("Enter Location : ");
			location = scanner.nextLine();
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
			System.out.print("Create Your Zmail : ");
			zmail = scanner.next();
			boolean isZmail=Verification.isZmail(zmail);
			if(!isZmail){
				System.out.println("ENTER A VALID ZMAIL...");
				continue ;
			}else if(Zmail.users.containsKey(zmail)){
				System.out.println("ZMAIL ID ALREADY EXISTS...");
				continue ;
			}
			System.out.print("password must conatain uppercase,lowercase,number,symbol");
			System.out.print("\nCREATE PASSWORD : ");
			password = scanner.next();
			boolean isValidPassword = Verification.checkPassword(password);
			if(!isValidPassword){
				System.out.println("ENTER A VALID PASSWORD..");
				continue ;
			}else{
				System.out.print("RE-ENTER YOUR PASSWORD : ");
				String pw = scanner.next();
				if(password.equals(pw)){
					User user = new User(name,phone,dob,location,zmail,password," "," ");
					Zmail.users.put(zmail,user);
					Zmail.saveUserData();
					step2 = false;
					System.out.println("\n--------------------------------");
					System.out.println("ZMAIL ID CREATED SUCCESSFULLY !");
					System.out.println("--------------------------------");
				}else{
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println(" WRONG PASSWORD !!!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
				}
			}
		}
	}
}