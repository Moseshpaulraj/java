import java.util.Scanner;
public class Question33{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter letter : ");
		char ch =scanner.next().charAt(0);
		if(ch>=97 && ch<=122 || ch>=65 && ch<=90){
			System.out.print("given letter is alphabet");
			}else{
			System.out.print("given letter is not an alphabet");
			}
		
	}
}
