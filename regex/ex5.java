import java.util.regex.*;
public class ex5{
	public static void main(String[] args){
		String str = "aaabbbabaaaabbbaca" ;
		
		//Pattern p = Pattern.compile("a+"); 
		//Pattern p = Pattern.compile("a*"); 
		//Pattern p = Pattern.compile("a?"); 
		Pattern p = Pattern.compile("a{3}"); 
		Matcher m = p.matcher(str);
		
		while(m.find()){
			System.out.println(m.group()+ m.start());
		}
	}
}