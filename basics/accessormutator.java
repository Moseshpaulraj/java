class accessormutator{
	int x;
	int y;
	static String a="what ?";
	accessormutator(){System.out.println("Enter the value");}
	accessormutator(int i ,int z){
		x=i;
		y=z;
	}
	void display(){
		System.out.println(x+" "+y+" "+a);
	}
	public static void main(String[] args){
		accessormutator am = new accessormutator(1,5);
		am.display();
	}
}
		
		