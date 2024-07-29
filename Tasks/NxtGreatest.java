public class NxtGreatest{
	public static void main(String[] args){
		int a = 469;
		String s = Integer.toString(a);
		char[]  ch =s.toCharArray();
		for(int i=ch.length-1;i>=0;i--){
			
			if(ch[-1+i]>=ch[(i)] ){
				//do nothing
			}else{
			char temp = ch[i];