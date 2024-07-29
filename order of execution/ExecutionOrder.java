public class MyClass {

	int instanceVariable = instanceMethod();

    {  System.out.println("Instance block invoked"); }

    int instanceMethod() {
        System.out.println("Instance method called");
	return 10;
    }




    static { System.out.println("Static block in MyClass executed"); }

    static int staticVariable = initializeStaticVariable();

    static int initializeStaticVariable() {
        System.out.println("Initializing static variable");
        return 10;
    }

    static void staticMethod() {
        System.out.println("Static method called");
    }

    

    MyClass() {
        System.out.println("Constructor of MyClass called");
        this.instanceVariable = 20;
    }

    public static void main(String[] args) {   

        System.out.println("Main method started");

        MyClass obj = new MyClass(); 

        obj.instanceMethod(); 

        staticMethod();  

        System.out.println("Main method completed");
    }
}