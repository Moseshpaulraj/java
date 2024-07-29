import java.io.*;
public class ReadAndWrite{
	public static void main(String[] args){
		File file = new File("C:\\Users\\mmose\\OneDrive\\Desktop\\folder\\newfile1");
		try{
		FileWriter fw = new FileWriter(file);
		fw.write("hi broww how r uuu ");
		fw.flush();
		fw.close();
		}
		catch(Exception e){
			System.out.println("oops!!!!");
		}
		try{
			
		/*FileReader fr = new FileReader(file);
		int input = fr.read();
		while(input!=-1){
			System.out.print((char)input);
			input = fr.read();
		}
		fr.close();*/

		FileReader fr = new FileReader(file);
		char[] arr = new char[(int)file.length()];
		System.out.println(arr.length);
		fr.read(arr);
		for(char c : arr){
			System.out.print(c);
		}
		
		}
		catch(Exception e){
			System.out.println("Something went wrong");
		}
	}
}