import java.util.*;
public class ex55{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		try{
		System.out.print("Enter input : ");
		int num = scanner.nextInt();
		int count = 1,count2=0 ,total = num*num;
		for(int i=1,j=total;i<=total;i++,j--){
			if(count%2==1){
				System.out.print(i + " ");
				count2++;
				if(count2==num){
					count++;
					count2=0;
					System.out.println();
					j=i+num+1;
				}
			}else if(count%2==0){
				System.out.print( j + " ");
				count2++;
				if(count2==num){
					count++;
					count2=0;
					System.out.println();
				}
			}
		}
		}
		catch(Exception e){
			System.out.println("Enter a valid input !!!!!! ");
		}
	}
}