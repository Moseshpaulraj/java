public class ExHandling{
	public static void main(String[] args){
		try{
		int a = Integer.parseInt("hello");
		}
		catch(Exception e){
			System.out.println("hey bro its a Error");}
		finally{
			System.out.println("from finally");
		}
		
	}
}