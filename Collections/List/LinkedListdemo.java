public class LinkedListDemo{
	public static void main(String[] args){

	}

}
public class ArrayList{
	node head;

	class node{
		int data;
		node next;
		node(int val){
			data = val;
			next = null;
		}
	ArrayList(){
		head = null ;
	}
	
	void insertAtBeginning(int val){
		node newNode = new node(val);
		
		if(head == null){
			head = newnode;
		}else
		{
			newnode.next = head;
			head = newnode;
		}
		
	}
	void display(){
		
	}
	}
}