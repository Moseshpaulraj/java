import java.util.Scanner;
public class Question{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter value of A: ");
		int a =scanner.nextInt();
		System.out.print("Enter value of B: ");
		int b =scanner.nextInt();
		System.out.print("Enter value of C: ");
		int c =scanner.nextInt();
		double x = (b*b)-(4*a*c);
		double root1=0,root2=0;
		if(x<0){
			System.out.println("no real roots");
		} else {
		root1 = (-b + Math.sqrt(x)) / (2*a);
		root2 = (-b - Math.sqrt(x)) / (2*a);
		System.out.println("roots are : \n" + "root1 : "+ root1 +"\nroot2 : " + root2  );
	}
		/*if((a*root1*root1) + (b*root1) + c == 0 || (a*root2*root2) + (b*root2) + c == 0 ){
			System.out.println("its a perfect polynomial equation !!!! ");
		} else {
			System.out.println("its a not perfect polynomial equation !!!! ");
		}*/
	}
}
