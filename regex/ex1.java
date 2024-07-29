import java.util.regex.*;
public class ex1{
	public static void main(String[] args){
		String str = "mosesh paul raj" ;
		Pattern p = Pattern.compile("s");
		Matcher m = p.matcher(str);
		
		while(m.find()){
			System.out.println(m.group()+ m.start()+m.end());		
		}
	}
}