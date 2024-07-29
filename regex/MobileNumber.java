import java.util.Scanner;
import java.util.regex.*;
public class MobileNumber{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter mobile no : ");
		String ph = sc.next() ;
		Pattern p = Pattern.compile("^(0|91)?[6-9][0-9]{9}$");
		Matcher m = p.matcher(ph);  
		if(m.find()){
			System.out.println(m.group()+" is a valid number");	
		}else{
			System.out.println(ph+" is not valid number");	
		
		}
	}
}