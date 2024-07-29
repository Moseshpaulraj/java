import java.util.regex.*;
import java.util.Scanner;
public class ex31{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter date1 : ");
		String date1 = scanner.nextLine();
		Pattern p =Pattern.compile("\\b(0*[1-9]|[12][0-9]|3[01])[-/\\s](0*[1-9]|1[12])[-/\\s](\\d{4})");
		Matcher match1 = p.matcher(date1);
		if(!match1.matches()){
			System.out.println("invalid input");
			System.exit(0);
		}
		System.out.print("Enter date2 : ");
		String date2 = scanner.nextLine();
		Matcher match2 = p.matcher(date2);
		if(!match2.matches()){
			System.out.println("invalid input");
			System.exit(0);
		}
		
		int d1 =Integer.parseInt(match1.group(1));
		int m1 =Integer.parseInt(match1.group(2));
		int y1 =Integer.parseInt(match1.group(3));
		int d2 =Integer.parseInt(match2.group(1));
		int m2 =Integer.parseInt(match2.group(2));
		int y2 =Integer.parseInt(match2.group(3));
		
		int year = yeardiff(y1,y2);
		int before = month(m1)+d1;
		if(m1>2 && y1%4==0){
			before += 1;	
		}
		int after = month(m2)+d2;
		if(m2>2 && y1%4==0){
			after += 1;	
		}
		int diff = year-before+after;
		System.out.println("Number of days : " + diff);
	}

	static int yeardiff(int y1 , int y2 ){
			int leap = 0 ;
			for(int i=y1;i<y2;i++){

				if( i % 4 == 0){
					leap++;
				}
			}

			int sum = y2-y1;
			sum = (sum * 365)+leap;
			return sum ;
		}
	
	static int month(int m){
		switch(m){
			case 1 :return 0 ;
			case 2 :return 31;
			case 3 :return 59;
			case 4 :return 90;
			case 5 :return 120;
			case 6 :return 151;
			case 7 :return 181;
			case 8 :return 212;
			case 9 :return 243;
			case 10 :return 273;
			case 11 :return 304 ;
			default :return 334;
		}
	}
}














