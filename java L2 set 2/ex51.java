import java.util.Arrays;
import java.util.Scanner;
public class ex51{
	public static void main(String[] args){
		/*Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Array row size : ");
		int size1 = scanner.nextInt();
		System.out.print("Enter Array coloum size : ");
		int size2 = scanner.nextInt();

		int[][] arr = new int[size1][size2];

		System.out.print("Enter Array values : ");
		for(int i=0;i<size1;i++){
			for(int j=0;j<size2;j++){
				arr[i][j] = scanner.nextInt();
			}
		} */
		int rev = -1 ;
		int size1 = 5 ;
		int size2 = 5 ;
		int[][] arr ={{1,0,1,0,0},
					{1,1,1,1,1},
					{0,0,0,1,0},
					{1,0,1,1,1},
					{0,1,1,0,1}};
	
		for(int i=0;i<size1-1;i++){
			for(int j=0;i<size2-2;j++){
				if(i==size1-2){
					System.out.println("yes");
				}
				else if(arr[i+1][j]==1){
					i=i+1;
					rev = 0 ;
				}else if(arr[i][j+1]==1){
					j=j+1;
					rev = 1 ;
				}else{
					if(rev==-1){
						System.out.println("No");
						System.exit(0);
					}else if( rev==0){
						i=i-1;
					}else if (rev==1){
						j=j-1;
					}
				}
			}
		}
		//System.out.println("total islands : " + count );
	}
}