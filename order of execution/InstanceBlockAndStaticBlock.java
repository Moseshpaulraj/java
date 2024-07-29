public class InstanceBlockAndStaticBlock
{	
	{System.out.println("A new Object Is Created");

	{System.out.println("A new Object Is Created1");}}      //----> Nested block
	
	static  int a=method();

	static
	{
		System.out.println("From Static Block");
			
	}

	public static int method()
	{
		new InstanceBlockAndStaticBlock();
		return 10;	
	}

	public static void main(String[] args)
	{
		new InstanceBlockAndStaticBlock();
		method();
	
	}
		
}