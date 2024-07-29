public class IntToString {
    public static void main(String[] args) {

        int Value1 = 123;
        int Value2 = 456;

        String intToString = Integer.toString( Value1 );

        System.out.println("Using Integer.toString(int): " + intToString);

        String valueOfString = String.valueOf( Value2 );

        System.out.println("Using String.valueOf(int): " + valueOfString);

	System.out.println( intToString + valueOfString );

        boolean isEqual = intToString.equals(valueOfString);

        System.out.println("Are the strings equal? " + isEqual);

        int compareToResult =valueOfString .compareTo(intToString);

        System.out.println("Compare result : " + compareToResult);

    }
}