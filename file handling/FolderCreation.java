import java.io.*;
public class FolderCreation{
	public static void main(String[] args){
		File file = new File("C:\\Users\\mmose\\OneDrive\\Desktop\\folder");
		boolean check = file.exists();
		System.out.println(check);
		if(check==false){
			file.mkdir();
		}
		System.out.println(file.exists());
	}
}