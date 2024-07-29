class tvs extends bike1{
	void run(){
		System.out.println("speedlimit");}
	public static void main(String[] args){
	bike1 b1= new tvs();
	b1.run();}
}
abstract class bike1{
	abstract void run();
}