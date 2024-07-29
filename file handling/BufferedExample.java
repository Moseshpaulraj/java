import java.io.*;
public class BufferedExample{
	public static void main(String[] args){
		File file = new File("C:\\Users\\mmose\\OneDrive\\Desktop\\folder\\newfile1");
		try{
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("hi broww how r uuu ");
		bw.newLine();
		bw.write("good morning!!!!");
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
		while(line!=null){
			System.out.println(line);
			line = br.readLine();
		}
		fr.close();
		}
		catch(Exception e){
			System.out.println("Something went wrong");
		}
	}
}