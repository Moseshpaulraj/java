import java.util.regex.*;
public class ex3{
	public static void main(String[] args){
		String str = "mosesh paul raj" ;
		//Pattern p = Pattern.compile("[amc]");
		//Pattern p = Pattern.compile("[^amc]");
		Pattern p = Pattern.compile("[a-m]");
		Matcher m = p.matcher(str);
		
		while(m.find()){
			System.out.println(m.group()+ m.start());
		}
	}
}