public class Recursion1{
	public static void main(String[] args){
		fibonacci_count(0,1,30);
	}
	public static void fibonacci_count(int a , int b , int count)
	{
		int c=a+b;
		if(c>count)
		{
			System.out.println("completed");
		}
		else
		{
			System.out.println(c);
			fibonacci_count(b,c,count);
		}
		
	}
}
