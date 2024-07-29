import java.util.Scanner; 
public class Question06{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter Input : ");
		String num = scanner.next();
		char[] numArr = num.toCharArray();

		for(int i = 0 ; i<numArr.length;i++){
			for(int j=0;j<numArr.length;j++){

				if (i == j || i + j == numArr.length - 1){
					System.out.print(numArr[i]);
				}
				else{
					System.out.print(" ");
				}

			}

			System.out.println();

		}
	}
}
