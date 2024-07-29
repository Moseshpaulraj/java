class TestInheritance{  
	public static void main(String args[]){  
	textStatic d=new textStatic();   
	d.eat();  
}
}
class textStatic
	{  
	private void eat(){System.out.println("eating...");}  
	}  
class Dog extends textStatic
	{  
	void eat(){System.out.println("barking...");}  
	}   
