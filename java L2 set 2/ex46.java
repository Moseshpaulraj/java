import java.util.*;
public class ex46{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter String1 : ");
		String str = scanner.nextLine();
		System.out.print("Enter String2 : ");
		String input = scanner.next();
		
		String[] arr = str.split(" ");
		int index=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i].contains(input)){
				index = i ;
				break ;
			}
		}
		String temp = "";
		int size = arr.length;
		for(int i=index,j=size-1;i<j;i++,j--){
			temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
		}
		
		
		System.out.print(Arrays.toString(arr));
	}
}
