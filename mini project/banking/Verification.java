import java.io.*;
import java.sql.*;
import java.util.Scanner;
import java.util.regex.*;
class Verification{
	static int account_num ;
	
	public static boolean isName(String input){
		Pattern pattern =Pattern.compile("^[A-Za-z][A-Za-z\\s]{3,29}$");
		Matcher matcher = pattern.matcher(input);
		boolean result = matcher.matches();
		return result ;
	}
		
	public static boolean isPhoneNo(String input){
		Pattern pattern =Pattern.compile("^(0|91)?[6-9][0-9]{9}$");
		Matcher matcher = pattern.matcher(input);
		boolean result = matcher.matches();
		return result ;
	}

	public static boolean isDob(String input){
		Pattern pattern =Pattern.compile("\\b(0*[1-9]|[12][0-9]|3[01])[-/\\s](0*[1-9]|1[12])[-/\\s](\\d{4})");
		Matcher matcher = pattern.matcher(input);
		boolean result = matcher.matches();
		if(result){
			int year = Integer.parseInt(matcher.group(3));
			if(year<1950){
				System.out.println("YOUR AGE IS TOO HIGH TO CREATE A ACCOUNT");
				result = false ;
			}else if(year>=2025){
				System.out.println("ENTER A VALID DATE OF BIRTH");
				result = false ;
			}else if(year>=2006){
				System.out.println("YOUR AGE IS TOO HIGH TO CREATE A ACCOUNT");
				result = false ;
			}else{
			result = true ;
			}
		}
		return result ;
	}
	public static boolean isLocation(String input){
		Pattern pattern =Pattern.compile("^[A-Za-z]{3,}$");
		Matcher matcher = pattern.matcher(input);
		boolean result = matcher.matches();
		return result;
	}
	public static boolean isValidPin(String input){
		Pattern pattern =Pattern.compile("^[0-9]{4}$");
		Matcher matcher = pattern.matcher(input);
		boolean result = matcher.matches();
		return result ;
	}
	public static boolean login(Connection connection){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Your Account Number : ");
		int acc_no = scanner.nextInt();
		boolean result = false ;
		try{
		String str = "SELECT pin FROM accounts WHERE account_no = ?;";
		PreparedStatement ps = connection.prepareStatement(str);
		ps.setLong(1,acc_no);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			int realPin = rs.getInt("pin");
			System.out.print("Enter your pin : ");
			int pin = scanner.nextInt();
			if(realPin!=pin){
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("INCORRECT PIN!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
			}else{
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("LOGIN SUCCESSFUL!!!");
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
				account_num = acc_no;
				return true ;
			}
		}else{
			System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("ACCOUNT NOT FOUND !!!");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
		}
	}catch(Exception e){
		System.out.println("Error in Login");
		}
		return result;
	}
}