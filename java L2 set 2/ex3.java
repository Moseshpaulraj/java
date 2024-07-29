import java.util.Scanner;
public class ex3{
	public static void main(String[] args){

		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Input : ");
		String input = scanner.nextLine();
		String[] arr = input.split(" ");
		int count = 0 ;

		boolean[] temp = new boolean[arr.length];
		
		for(int i = 0  ; i<arr.length ; i++){
			if(temp[i]==false){
				count = 0 ;
				for(int j = i ; j<arr.length ;j++){
					if(arr[i].equals(arr[j])){
						count++;
						temp[j]=true;
					}
				}
				if(count>1){
				System.out.println(arr[i]+" " + --count);
				}
			}
		}
	}
}