class InstanceBlockTest1 extends Parent
{  
	public static void main(String args[])
	{  
		InstanceBlockTest1 b=new InstanceBlockTest1();
		
	} 
	InstanceBlockTest1()
	{  
		//super(); -----> compiler adds it 
		System.out.println("child constructor invoked");    //3
	}  
 
	{System.out.println("instance block is invoked");}          //2
  
	 
}
class Parent
{  
	Parent()
	{  
		System.out.println("parent constructor invoked");    //1
	}  
}  
  