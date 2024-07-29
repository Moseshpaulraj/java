import java.io.*;
public class DeleteSpecificSize{
	public static void main(String[] args){
		File file = new File("D:\\javabasics");
		
		File[] arr = file.listFiles();
		
		for(File f : arr){
			String name = f.getName();
			int dot = name.lastIndexOf(".");
			String extension = name.substring(dot+1);
			if(extension.equals("txt")){
				if(f.length()>=0)
					f.delete();
			}
		}
	}
}