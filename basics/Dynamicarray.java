import javabasics.Ary;
public class Dynamicarray{
	public static void main(String[] args){
		Ary numbers = new Ary(3);
		numbers.insert(5);
		numbers.insert(6);
		numbers.insert(7);
		System.out.println(numbers.indexof(2));
		numbers.print();
	}
}

		