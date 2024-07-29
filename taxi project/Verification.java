import java.util.regex.*;
class Verification{
	
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
	
	public static boolean checkPassword(String input){
		char[] arr = input.toCharArray();
		boolean lowerCase = false ;
		boolean upperCase = false ;
		boolean numbers = false ;
		boolean symbols = false ;
			
		for(int i=0;i<arr.length;i++){
			 if(Character.isDigit(arr[i])){
				numbers = true ;
			 }else if (Character.isUpperCase(arr[i])){
				upperCase = true ;
			 }else if (Character.isLowerCase(arr[i])){
				lowerCase = true ;
			 }else{
				 symbols = true ;
			 }
		}
		if(arr.length>7&&symbols&&numbers&&lowerCase&&upperCase){
			return true;
		}else{
			System.out.println("Invalid password!!");
			return false;
		}
	}
}