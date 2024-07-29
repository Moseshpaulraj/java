import java.util.regex.*;
public class ex6{
	public static void main(String[] args){
		String s1 = "aaabbbabaaaabbbaca" ;
		 
		Pattern p = Pattern.compile("a"); 
		String[] str = p.split(s1);

		for(String i : str){
			System.out.println(i);
		}
	}
}