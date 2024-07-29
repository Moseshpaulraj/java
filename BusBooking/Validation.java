import java.util.regex.*;
class Validation{
	public static boolean isValidName(String input){
		Pattern pattern =Pattern.compile("^[A-Za-z][A-Za-z\\s]{3,29}$");
		Matcher matcher = pattern.matcher(input);
		boolean result = matcher.matches();
		return result ;
	}
		
	public static boolean isValidPhoneNo(String input){
		Pattern pattern =Pattern.compile("^(0|91)?[6-9][0-9]{9}$");
		Matcher matcher = pattern.matcher(input);
		boolean result = matcher.matches();
		return result ;
	}
	
	public static boolean isValidPassword(String input){
		Pattern pattern =Pattern.compile("^(?!\\s)(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W]).{8,100}(?<!\\s)$");
		Matcher matcher = pattern.matcher(input);
		boolean result = matcher.matches();
		return result ;
	}
	public static boolean isValidDate(String input){
		Pattern pattern =Pattern.compile("^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$");
		Matcher matcher = pattern.matcher(input);
		boolean result = matcher.matches();
		return result ;
	}
}