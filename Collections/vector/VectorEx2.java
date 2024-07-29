import java.util.*;
public class VectorEx2{
	public static void main(String[] args){
		int size = 1000000;

		long start = System.currentTimeMillis();
		List<Integer> list1 =Collections.synchronizedList(new ArrayList<Integer>());
		Thread t1 = new  Thread(()->{
			for (int i=0;i<size;i++){
				list1.add(i);
			}
		});
		Thread t2 = new  Thread(()->{
			for (int i=0;i<size;i++){
				list1.add(i);
			}
		});

		t1.start();
		t2.start();
		try{
			t1.join();} catch(Exception e){}

		try{
			t2.join();} catch(Exception e){}
		long end = System.currentTimeMillis();
		System.out.println(" totaltime " + (end - start) + " ms");
		System.out.println(list1.size());	





		start = System.currentTimeMillis();
		Vector<Integer> list2 = new Vector<Integer>();
		t1 = new  Thread(()->{
			for (int i=0;i<size;i++){
				list2.add(i);}
		});
		t2 = new  Thread(()->{
			for (int i=0;i<size;i++){
				list2.add(i);}
		});

		t1.start();
		t2.start();
		try{
			t1.join();} catch(Exception e){}
		try{
			t2.join();} catch(Exception e){}
		end = System.currentTimeMillis();
		System.out.println(" totaltime " + (end - start) + " ms");
		System.out.println(list2.size());		
	}	
}