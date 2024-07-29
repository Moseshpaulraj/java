import java.io.*;
public class SubFolderCreation{
	public static void main(String[] args){
		File file = new File("C:\\Users\\mmose\\OneDrive\\Desktop\\folder\\subFolder\\sub");
		boolean check = file.exists();
		System.out.println(check);
		if(check==false){
			file.mkdirs();
		}
		System.out.println(file.exists());
	}
}