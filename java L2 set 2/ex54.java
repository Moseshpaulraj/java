import java.util.*;
public class ex54{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		try{
		System.out.print("Number of process : ");
		int process = scanner.nextInt();
		boolean[] arr = new boolean[process];
		System.out.print("Enter Start Position : ");
		int start = scanner.nextInt();
		System.out.print("Skip Position : ");
		int skip = scanner.nextInt();
		int count1 =0 ;
		int count2 =1 ;
		
		for(int j=0;count1<process-1;j++){
			for(int i=start;count1<process-1;i++){
				i = i % process ;
				if(count2==skip && arr[i]==false){
					arr[i]=true;
					start = i ;
					count2=1;
					count1++;
					break;
				}else if(arr[i]==false){
					count2++;
				}
			}
		}
		for(int i=0;i<process;i++){
			if(arr[i]==false){
				System.out.println( i+1 + " is the safe position");
			}
		}
		}
		catch(Exception e){
			System.out.println("Enter a valid input !!!!!! ");
		}
	}
}