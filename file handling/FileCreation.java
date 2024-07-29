import java.io.*;
public class FileCreation{
	public static void main(String[] args){
		File file = new File("C:\\Users\\mmose\\OneDrive\\Desktop\\folder\\newfile.txt");
		boolean check = file.exists();
		if(check==false){
			try{
			boolean create = file.createNewFile();
			System.out.println("File Created "+create);
			}
			catch(Exception e){
				System.out.println("something went wrong");
			}
		}
	}
}