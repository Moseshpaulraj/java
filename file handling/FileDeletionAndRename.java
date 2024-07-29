import java.io.*;
public class FileDeletionAndRename{
	public static void main(String[] args){
		File file = new File("C:\\Users\\mmose\\OneDrive\\Desktop\\folder\\newfile.txt");
		//file.delete();
		File file1 = new File("C:\\Users\\mmose\\OneDrive\\Desktop\\folder\\newfile1.txt");
		file.renameTo(file1);
	}
}