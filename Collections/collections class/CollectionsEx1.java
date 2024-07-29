import java.util.*;

public class CollectionsEx1 {
	public static void main(String[] args) {
        	List<Integer> numbers = new ArrayList<>();
        	numbers.add(5);
        	numbers.add(3);
        	numbers.add(8);
        	numbers.add(1);
		//numbers.add(null);


        	System.out.println("Before sorting: " + numbers);
        	Collections.sort(numbers);
        	System.out.println("After sorting: " + numbers);


	 	int index = Collections.binarySearch(numbers, 5);
        	System.out.println("Index of 5: " + index);
        
        	System.out.println("Minimum number: " + Collections.min(numbers));
        	System.out.println("Maximum number: " + Collections.max(numbers));

		List<Boolean> num = new ArrayList<>();
		num.add(true);
		num.add(true);
		num.add(false);
		num.add(false);

		System.out.println(num);
		Collections.sort(num);
        	System.out.println("After sorting: " + num);

    }
}
