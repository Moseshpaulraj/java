public class Question48{
	public static void main(String[] args){
		for(int i=9;i>0;i--){
			for(int j=0;j<i;j++){
				System.out.print(" ");
			}
			for(int j=i;j<=9;j++){ 
				System.out.print(j);
			}
			
			for(int j=8; j>=i;j--){
				System.out.print(j);
			}	
		System.out.println();
		}
	}
}
