import java.util.Scanner;
public class Question13{
	public static void main(String[] args){
		final double PI = 3.14159;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Radius of the circle : ");
		int radius = scanner.nextInt();

		double area = PI * radius * radius ;
		System.out.println("Area of the circle is :"+ Math.round(area));
	}
}
