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

	public static boolean isDob(String input){
		Pattern pattern =Pattern.compile("\\b(0*[1-9]|[12][0-9]|3[01])[-/\\s](0*[1-9]|1[12])[-/\\s](\\d{4})");
		Matcher matcher = pattern.matcher(input);
		boolean result = matcher.matches();
		if(result){
			int year = Integer.parseInt(matcher.group(3));
			if(year<1950){
				System.out.println("YOUR AGE IS HIGH TO CREATE A ACCOUNT");
				result = false ;
			}else if(year>=2025){
				System.out.println("ENTER A VALID DATE OF BIRTH");
				result = false ;
			}else if(year>=2006){
				System.out.println("YOUR AGE IS LOW TO CREATE A ACCOUNT");
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
	
	public static boolean isZmail(String input){
		Pattern pattern =Pattern.compile("^[a-zA-Z0-9]{5,30}@zmail.com$");
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