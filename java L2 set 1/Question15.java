import java.util.Scanner;
public class Question14{
	public static void main(String[] args){
		final double PI = 3.14159;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter radius of the cylinder: ");
		double radius = scanner.nextDouble();
		System.out.print("Enter height of the cylinder: ");
		double height = scanner.nextDouble();
		double lateralSurfaceArea =2 * PI * radius * height;
		double totalSurfaceArea =2 * PI * radius * (radius + height);
		System.out.println("LateralSurfaceArea of the Cylinder is :"+ lateralSurfaceArea);
		System.out.println("TotalsurfaceArea of the Cylinder is :"+ totalSurfaceArea);
	}
}
