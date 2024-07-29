public class Question49{
	public static void main(String[] args){
		for(int i=9;i>0;i--){
			
			for(int j=i;j<=9;j++){
				System.out.print(" ");
			}
			for(int j=i;j>0;j--){
				if(j%2==0){
				}else{System.out.print(" ");
				System.out.print(i);
				}
			}
			for(int j=i-1; j>0;j--){
				if(j%2==0){
				}else{System.out.print(" ");
				System.out.print(i);
				}
			}	
		System.out.println();
		}
	}
}
