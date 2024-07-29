public class TernaryEx3{
	public static void main(String[] args){
		boolean condition = false ;

		String result = (condition ? System.out::print : System.out::println);

		System.out.println(result);
	}

	public static String method1(){
		return "From Method 1 ";
	}

	public static String method2(){
		return "From Method 2 ";
	}
}