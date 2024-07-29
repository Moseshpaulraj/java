import java.util.*;
public class DynamicArrayDemo{
	public static void main(String args[]){
	DynamicArray list = new DynamicArray();
	Scanner scanner = new Scanner(System.in);
	int val,pos;

	while(true){

	System.out.println("---------------------");
	System.out.println("        MENU         ");
	System.out.println("---------------------");
	System.out.println("1.Insert a value");
	System.out.println("2.Insert at Specific position");
	System.out.println("3.Delete a specific value");
	System.out.println("4.find value of index");
	System.out.println("5.Display");
	System.out.println("6.Exit");
	System.out.println("--------------------");
	System.out.print("Enter your choice:");

	int choice = scanner.nextInt();

	switch(choice){
	case 1 :
		System.out.print("Enter a value:");
		val = scanner.nextInt();
		list.insertValue(val);
		break;
	case 2 :
		System.out.print("enter the position :");
		pos = scanner.nextInt();
		System.out.print("Enter a value:");
		val = scanner.nextInt();
		list.insertAt(pos,val);
		break;
	case 3 :
		System.out.print("enter the position :");
		pos = scanner.nextInt();
		list.deleteAt(pos);
		break;
	case 4 :
		System.out.print("Enter index value:");
		pos = scanner.nextInt();
		list.valueAt(pos);
		break;
	case 5 :
		list.display();
		break;

	case 6:
		System.exit(0);
		default :
		System.out.println("Enter a valid choice:");	
	}
	}
	}
}
class DynamicArray{
	int[] arr ;
	int size;
	int capacity;
	static final int initialcapacity=16;
	
	DynamicArray(){
		size=0;
		arr = new int[initialcapacity];
		capacity=initialcapacity;
	}
	void insertValue(int val){
		if(size>=capacity)
		{
			expandArray();
		}
		arr[size++]=val;	
	}
	void display(){
	for (int i=0;i<size;i++){
		System.out.println(arr[i]);
		}
	}
	void insertAt(int pos, int val){
		for(int i=size-1;i>=pos;i--){
		arr[i+1]=arr[i];
		}
		arr[pos]=val;
		size++;
		
	}
	void deleteAt(int pos){
		for(int i=pos+1;i<=size-1;i++){
		arr[i-1]=arr[i];
		}
		size--;
	}
	void valueAt(int pos){
		System.out.println("value at the Index " + pos + " is " + arr[pos]);
	}
	void expandArray(){
		capacity=capacity*2;
		arr=java.util.Arrays.copyOf(arr,capacity);
	}
	 
}
