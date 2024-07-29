public class TernaryEx1{
	public static void main(String[] args){
		boolean condition = true;
		int maxcount =10 ;
		int mincount = 5 ;

		for(int i=0 ; i<(condition ? maxcount : mincount) ; i++){
			System.out.println("Iteration : "+ i);
		}
				
	}
}