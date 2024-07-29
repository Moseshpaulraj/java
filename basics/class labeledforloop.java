class labeledforloop{
	public static void main(String args[]){
		first :
		for(int i=1;i<6;i++){
			second :
			for(int j=1;j<=i;j++){
				if(j==3)
				break second ;
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}