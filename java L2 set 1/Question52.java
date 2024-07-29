import java.util.Scanner; 
public class Question52{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Input : ");
		String str = scanner.nextLine();
		String[] words = str.split(" ");
		Question52.reverse(words , words.length-1);
	}
	public static void reverse(String[] words , int index){
		if(index>=0){
			System.out.print(words[index]+" " );
			reverse(words,index-1);
		}
	}
}
