import java.util.*;
public class StackExample {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
        	stack.push(10);
        	stack.push(20);
        	stack.push(30);
        	stack.push(40);
		stack.remove(0);
        	System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.peek());
        	System.out.println(stack.isEmpty());
        	System.out.println(stack.search(10));
		
	}
}