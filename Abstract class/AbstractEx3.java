public class AbstractEx3{
	public static void main(String args[]){
		MyInterface obj =new SubClass();  
		obj.method1();
		obj.method2();
		obj.method3();
		obj.method4();
	}
}

interface MyInterface {
	public void method1();  
	public void method2();  
	public void method3();  
	public void method4();  
}
  
abstract class AbstractClass implements MyInterface{
	public void method3()
	{
		System.out.println("method 3");
	}
}
  
class SubClass extends AbstractClass{  
	public void method1(){
		System.out.println("method 1");
	}
	public void method2(){
		System.out.println("method 2");
	}
	public void method4(){
		System.out.println("method 4");
	}
}