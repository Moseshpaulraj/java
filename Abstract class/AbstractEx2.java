public class AbstractEx2{
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.Sound();
        myDog.eat();
        myDog.sleep();
    }
}

abstract class Animal 
{
	public abstract void Sound();

	public void sleep()
	{
        System.out.println("Animal is sleeping");
    	}
}


abstract class Pet extends Animal {
	public abstract void eat();
}


class Dog extends Pet 
{
	public void Sound()
	{
        	System.out.println("Dog barks");
    	}
   	public void eat()
	{
        	System.out.println("Dog eats bones");
    	}
}