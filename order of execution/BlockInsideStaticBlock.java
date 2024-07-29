//static block inside block and vice versa
//instance block can be inside static block but not vice versa

public class BlockInsideStaticBlock
{	
	{
		System.out.println("A new Object Is Created");
		static						//-----> illegal start of expression
		{
			System.out.println("From Static Block");
			
	
		}
			
	}		
	
	public static void main(String[] args)
	{
		new BlockInsideStaticBlock();
		
		
	}
		
}