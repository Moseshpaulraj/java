import java.util.Scanner;
public class Question14{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter length of the Rectangle: ");
		double length = scanner.nextDouble();
		System.out.print("Enter width of the Rectangle: ");
		double width = scanner.nextDouble();
		double area = length * width ;
		System.out.println("Area of the Rectangle is :"+ area);
	}
}
