import java.util.Scanner;
public class ex34{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Your password : ");
		String str= scanner.next();
		char[] array = str.toCharArray();
		String result = PasswordStrength(array);
		System.out.println(result);
	}
		public static String PasswordStrength(char[] arr){
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
			
			if(arr.length<8&&symbols&&numbers&&lowerCase&&upperCase){
				return " Weak password !!";
			}else{
				return " $$ Strong password $$ ";
			}
		}
}
