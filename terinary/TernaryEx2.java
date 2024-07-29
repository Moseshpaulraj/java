public class TernaryEx2{
	public static void main(String[] args){
		int mark = 60 ;

		char grade = (mark>=90 ? 'A' : (mark>=70 ? 'B' : ( mark>=50 ? 'c' : 'd')));

		System.out.println("Grade " + grade);
	}
}