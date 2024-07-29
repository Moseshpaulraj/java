class demo{
	class demo1{
		private void print(){System.out.println("main");}
	}
}
abstract class Abstract1 extends demo{
	abstract void print();
}
public class Abstract{
	public static void main(String args[]){
	demo.demo1 mydemo = new demo().new demo1();
	mydemo.print();
	}
}
