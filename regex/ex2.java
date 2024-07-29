import java.util.regex.*;
public class ex2{
	public static void main(String[] args){
		String str = "mosesh paul raj" ;
		Pattern p = Pattern.compile("^m");
		Pattern p1 = Pattern.compile("j$");
		Matcher m = p1.matcher(str);
		
		while(m.find()){
			System.out.println(m.group()+ m.start());
		}
	}
}