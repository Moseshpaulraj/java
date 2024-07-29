public class RecursionExample{
static int factorial(int n){
return(n* factorial(n-1));
}
public static void main(String[] args) {
System.out.println("Factorial of 5 is: "+factorial(5));
}
}