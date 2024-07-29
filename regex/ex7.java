import java.util.regex.*;
public class ex7{
	public static void main(String[] args){
		String s1 = "9876-8971-9874-9876" ;
		 
		Pattern p = Pattern.compile("\\d{4}-\\d{4}-\\d{4}-"); 
		Matcher m = p.matcher(s1);
		
		String s = m.replaceAll("XXXX-XXXX-XXXX-");
		System.out.println(s);
		}
}