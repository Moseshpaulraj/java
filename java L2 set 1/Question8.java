public class Question8{
	
	static { System.out.println("Static block "); }

	static int a = 10 ;
	int b = 20 ;

	static void Method1() {
		System.out.println("Static method");
	}

	{  System.out.println("Instance block"); }

	public void Method2() {
		System.out.println("Instance method");
	}

	public static void main(String[] args) {   
		Question8 obj = new Question8(); 
		Method1();
		obj.Method2();  
		System.out.println(a);	 
	}
	
}