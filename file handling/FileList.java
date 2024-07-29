import java.io.*;
import java.util.Arrays;
public class FileList{
	public static void main(String[] args){
		File file = new File("D:\\javabasics");
		String[] list = file.list();
		System.out.println(Arrays.toString(list));
		
		File[] arr = file.listFiles();
		
		for(File f : arr){
			if(f.isDirectory()){
				System.out.println(f);
			}
		}
		for(File f : arr){
			if(f.isFile()){
				System.out.println(f);
			}
		}
	}
}