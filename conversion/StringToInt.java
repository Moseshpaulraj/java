public class StringToInt{
    public static void main(String[] args) {

        String str = "123";
        int parsedInt = Integer.parseInt(str);
        System.out.println("Parsed int value using parseInt(): " + parsedInt);
	String a = null ;
	int b = 200 ;
        Integer valueOfInt = Integer.valueOf(a);
        System.out.println("Integer object value using valueOf(): " + valueOfInt);
        Integer anotherInt = Integer.valueOf("123");

	//System.out.println(valueOfInt + parsedInt);
        
        System.out.println("Is valueOfInt equal to anotherInt ? " + valueOfInt.equals(anotherInt));
        
       //System.out.println("Is valueOfInt equal to anotherInt? " + parsedInt.equals(anotherInt));
    }
}