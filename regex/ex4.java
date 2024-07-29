import java.util.regex.*;
public class ex4{
	public static void main(String[] args){
		String str = "mosesh paul raj" ;
		//Pattern p = Pattern.compile("\\s");  // for space
		//Pattern p = Pattern.compile("\\S");
		//Pattern p = Pattern.compile("\\bmosesh");   //boundary
		//Pattern p = Pattern.compile("\\bmosesh\\b");
		//Pattern p = Pattern.compile("\\w");
		Pattern p = Pattern.compile("\\W"); // words
		//Pattern p = Pattern.compile(".");     //all
		Matcher m = p.matcher(str);
		
		while(m.find()){
			System.out.println(m.group()+ m.start());
		}
	}
}