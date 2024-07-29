public class InstanceBlockTest
{	
	{System.out.println("A new Object Is Created");}

	public static void main(String[] args)
	{
		Parent parent=new Parent();
		Child child=new Child();
		Parent obj=new Child();   
		InstanceBlockTest obj1=new InstanceBlockTest();
	}	
}
public class Parent
{	
	{System.out.println("A new Object Is Created for Parent");}	
}
public class Child extends Parent
{	
	{System.out.println("A new Object Is Created for child");}
}