import java.util.Scanner;
public class Diamond{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter diamond size : ");
		int n =scanner.nextInt();


		for(int i=1;i<=n+1;i++){
			for(int j=i;j<n+1;j++){
				System.out.print(" ");
			}
			for(int j=1 ;j<i;j++){
				if(j%2==1){System.out.print(" ");
				}else{
				System.out.print("*");
				}
			}
			for(int j=i ; j>0;j--){
				if(j%2==1){System.out.print(" ");
				}else{
				System.out.print("*");
				}
			}
			System.out.println();
		}

		for(int i=n+1;i>0;i--){
			for(int j=i;j<=n+1;j++){
				System.out.print(" ");
			}
			for(int j=i;j>2;j--){
				if(j%2==0){
				}else{System.out.print(" ");
				System.out.print("*");
				}
			}
			
			for(int j=i-1; j>2;j--){
				if(j%2==0){
				}else{System.out.print(" ");
				System.out.print("*");
				}
			}	
		System.out.println();
		}
	}
}
