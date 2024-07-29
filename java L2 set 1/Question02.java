import java.util.Scanner; 
public class Question02{
	public static void main(String[] args){
		int x = 0 ;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a letter : ");
		char ch = scanner.next().charAt(0);
		if(ch>90&&ch<97 || ch>122 || ch<65){
			System.out.println("Enter valid input");
			System.exit(0);
		}
		else if(ch>=97){
			x=122;
		}else{
			x=90;
		}
		for(char i=ch;i<=x;i++){
			System.out.print(i);
		}
	}
}