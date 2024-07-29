import java.util.Scanner;
public class Question29{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a letter: ");
		int ch =scanner.next().charAt(0);
		switch(ch){
			case 'a' :
			case 'e' :
			case 'i' :
			case 'o' :
			case 'u' :
			case 'A' :
			case 'E' :
			case 'I' :
			case 'O' :
			case 'U' :
				System.out.println("it is a vowel");
				break;
			default :
				System.out.println("its consonant");
				
		}
	}
}
