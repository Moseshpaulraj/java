class inheritancetest1{
	public static void main(String[] args){
		dog d1 = new dog();
		d1.printdisplay();
	}
}
class Animal1{
	String color = "blue";
}
class dog extends Animal1{
	String color = "red";
	public void printdisplay(){
		System.out.println(color);
		System.out.println(super.color);
	}
}
		
