import java.io.*;
public class CountExample{
	public static void main(String[] args){
		File file = new File("C:\\Users\\mmose\\OneDrive\\Desktop\\folder\\newfile1");
		try{
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("hi broww how r uuu.");
		bw.newLine();
		bw.write("good morning!!!!.");
		bw.flush();
		bw.close();
		}
		catch(Exception e){
			System.out.println("oops!!!!");
		}
		try{
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		int scentenceCount=0;
		int wordsCount=0;
		int lettersCount=0;
		while(line!=null){
			System.out.println(line);
			String[] scentencearr =line.split("[.]");
			scentenceCount+=scentencearr.length;
			String[] wordsarr =line.split(" ");
			wordsCount+=wordsarr.length;
			lettersCount+=line.length();
			line = br.readLine();
		}
		fr.close();
		System.out.println("total scentence : " + scentenceCount);
		System.out.println("words : " +wordsCount);
		System.out.println("letters count : " + lettersCount);
		}
		catch(Exception e){
			System.out.println("Something went wrong");
		}
	}
}