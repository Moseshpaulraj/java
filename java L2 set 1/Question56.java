import java.util.Scanner;
public class Question56{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number: ");
		int input =scanner.nextInt();
		int count=1;
		int total,k = 0;
		for(total=1;k<input;total++){
			k+=total;
		}
		
		a :
		for(int i=1;count<=input;i++){
			for(int j=i;j<=total;j++){
				System.out.print(" ");
			}
			for(int j=1;j<i;j++){
				if(j%2==1){
					if(count>input){
						break;
					}else{
						if(count<=9)
							System.out.print("  "+count++);
						else
							System.out.print(" "+count++);
					}
				}
			}
			for(int j=i;j>0;j--){
				if(j%2==1){
					if(count>input){
						break a;
					}else{
						if(count<=9)
							System.out.print("  "+count++);
						else
							System.out.print(" "+count++);
					}
				}
			}
		System.out.println();
		} 
	}
}
