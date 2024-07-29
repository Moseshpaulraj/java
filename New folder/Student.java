class Student{
	
	String name ;
	int rollNo ;
	int age ;
	String department;
	String college;
	
	Student(String name){
		this.name = name;
	}
	
	Student(String name,int no,int age,String department,String college){
		this.name = name;
		this.rollNo = no;
		this.age=age;
		this.department=department;
		this.college=college;
	}
	
	public void study(){
		System.out.println(" is studying");
	}
	
	public void printage(){
		System.out.println(age);
	}
	
	public static void main(String[] args){
	
		Student pricy = new Student("victoria");
		
		pricy.printage();
	
	
	}
}