package javabasics;
import java.lang.ArrayStoreException;
abstract class member{
	private String name;
	abstract void welcomemsg();
	public String getName(){
		return name;	 
	}
}

class student extends member{
	void welcomemsg(){
		System.out.println("HELLO STUDENT...");
	}
}

class teacher extends member{
	void welcomemsg(){
		System.out.println("HELLO STUDENT...");
	}
}

public class Abstractdemo{
	public static void main(String[] args){
	member[] m = new student[4];
	m[0]=new teacher();
	m[1]=new teacher();
	m[2]=new student();
	m[3]=new teacher();

	for(member m1 : m){
		m1.welcomemsg();
		}
	}
}