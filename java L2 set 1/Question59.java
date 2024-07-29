import java.util.Scanner;
public class Question59{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Input : ");
		char[] arr1 = scanner.nextLine().toCharArray();

		System.out.print("Enter substring : ");
		char[] arr2 = scanner.nextLine().toCharArray();
		int count = 0 ;
		int l1 =arr1.length;
		int l2 =arr2.length;

		a :
		for(int i =0;i<l1;i++){
			int k = i ;
			for(int j=0;j<l2;j++){
				if(j<l2 && k<l1 && arr1[k]==arr2[j]){
					k++;
					count++;
					}else {
						count = 0 ;
					}
				if(count==arr2.length){
					System.out.println(i);
					break a;
					}
				}
				
			}

			if(count!=arr2.length){
			System.out.println("-1");
			}
		}
	
}