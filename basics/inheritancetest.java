class inheritancetest{
	public static void main(String[] args){
		babydog d1 = new babydog();
		d1.eat();
		d1.bark();
		d1.weep();
	}
}
class Animal1{
	void eat(){
		System.out.println("eating...");
	}
}

class dog extends Animal1{
	void bark(){
		System.out.println("barking...");
	}
}

class babydog  extends dog{
	void weep(){System.out.println("weeping...");
	}
}
		
