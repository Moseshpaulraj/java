class Example2{
	public static void main(String[] args){
	
		Monkey pricy = new Monkey();
		pricy.eat("prichi",10);
		
	}
}

class Animal{
	
	public void eat(){
		System.out.println("animal eat using mouth");
	}
	
}

class Monkey extends Animal{

	public void eat(){
		System.out.println("Monkey eat using hands");
	}
	
	public void eat(int a){
		System.out.println("Monkey eat "+ a +" times a day");
	}
	
	public void eat(String name){
		System.out.println(name +" monkey is eating");
	}
	
	public void eat(String name ,int a){
		System.out.println(name+" Monkey eat "+ a +" times a day");
	}
}
