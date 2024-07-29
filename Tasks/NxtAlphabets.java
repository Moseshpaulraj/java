import java.util.Scanner; 
public class NxtAlphabets{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a letter : ");
		char c = sc.next().toUpperCase().charAt(0);
		for(char i=c;i<=90;i++){
			System.out.print(i);
		}
	}
}
