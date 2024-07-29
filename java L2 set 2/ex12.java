import java.util.Scanner;
public class ex12{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		try{
		System.out.print("Enter diamond size : ");
		int n =scanner.nextInt();
		char c = 'A';

		for(int i=1;i<=n+1;i++){
			c = 'A';
			for(int j=i;j<n+1;j++){
				System.out.print(" ");
			}
			for(int j=1 ;j<i;j++){
				if(j%2==1){System.out.print(" ");
				}else{
				System.out.print((char)c++);
				}
			}
			for(int j=i ; j>0;j--){
				if(j%2==1){System.out.print(" ");
				}else{
				System.out.print((char)c++);
				}
			}
			System.out.println();
		}

		for(int i=n+1;i>0;i--){
			c = 'A';
			for(int j=i;j<=n+1;j++){
				System.out.print(" ");
			}
			for(int j=i;j>2;j--){
				if(j%2==0){
				}else{System.out.print(" ");
				System.out.print((char)c++);
				}
			}
			
			for(int j=i-1; j>2;j--){
				if(j%2==0){
				}else{System.out.print(" ");
				System.out.print((char)c++);
				}
			}	
		System.out.println();
		}
	}catch(Exception e){
		System.out.println("invalid size");	
	}
	}
}
