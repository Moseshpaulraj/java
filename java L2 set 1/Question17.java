import java.util.Scanner;
public class Question17{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter radius of 1st circle : ");
		int r1 =scanner.nextInt();
		System.out.print("Enter radius of 2st circle : ");
		int r2 =scanner.nextInt();
		double area = 0 ;
		final double PI =  3.14159;
		if(r2>r1){
			area = PI*((r2*r2) - (r1*r1));
		} else {
			area = PI*((r1*r1) - (r2*r2));
		}
		System.out.println("area of space : " + area );
	}
}
