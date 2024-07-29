import java.util.Scanner;
import java.util.regex.*;
public class ex44{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter versions : ");
		String version = sc.nextLine() ;

		Pattern p = Pattern.compile("^version1 ([0-9]).([0-9]).([0-9]) version2 ([0-9]).([0-9]).([0-9])$");

		Matcher m = p.matcher(version);
		
		if(!m.matches()){
			System.out.println("Enter valid input !!!");
			System.exit(0);
		}
		
		int g1=Integer.parseInt(m.group(1));
		int g2=Integer.parseInt(m.group(2));
		int g3=Integer.parseInt(m.group(3));
		int g4=Integer.parseInt(m.group(4));
		int g5=Integer.parseInt(m.group(5));
		int g6=Integer.parseInt(m.group(6));
		
		if(g1>g4||g2>g5||g3>g6)
		{
			System.out.println("downgraded");
		}else if(g1<g4||g2<g5||g3<g6){
			System.out.println("upgraded");
		}else{
			System.out.println("same version");
		}
	
	}
}