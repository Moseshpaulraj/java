import java.util.Scanner; 
public class Question05{
	public static void main(String[] args){
		int x=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a letter : ");
		char ch = sc.next().charAt(0);
		if(ch>90&&ch<97 || ch>122 || ch<65){
			System.out.println("Enter valid input");
			System.exit(0);
		}
		else if(ch>=97){
			x=97;
		}else{
			x=65;
		}	
		for(char i=ch;i>=x;i--){
			for(int j=0;j<=i-x;j++){
				System.out.print(i);
			}
		System.out.println();
		}
	}
}
