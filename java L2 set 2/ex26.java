import java.util.Scanner;
public class ex26{

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter String : ");
		String str1 = scanner.nextLine();
		System.out.print("Enter Specific chars : ");
		String str2 = scanner.nextLine();
		
		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();
		boolean[] temp = new boolean[arr1.length];

		for(int i=0;i<arr2.length;i++){
			for(int j=0;j<arr1.length;j++){
				if(arr1[j]==arr2[i]){
					temp[j]=true;
				}
			}
		}
		String str ="";
		for(int i=0;i<arr1.length;i++){
			if(temp[i]==false){
				str+=arr1[i];
			}
		}
		
		System.out.println(str);
	}
}