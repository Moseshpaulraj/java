import java.util.*;

public class LinkedlistExample2{	
	public static void main(String args[]) {
		Book b1 = new Book(101,"My Success story","Sakthivel",9);
		Book b2 = new Book(102,"Machine Learning Book","Rahul",10);
		Book b3 = new Book(103,"java collections","Mosesh",7);
		
		LinkedList<Book> list = new LinkedList<Book>();
		LinkedList list1 = new LinkedList();
		System.out.println(list1);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		for(Book b : list){
			System.out.println("Name of the BOOK     :"+b.name +
					   "\nID of the BOOK     :" + b.bookid +
					   "\nauthor of the BOOK :"+ b.author + 
					   "\navailable quantity :"+ b.quantity);
		}
		
	}
}

class Book{
	int bookid,quantity;
	String name,author;

	public Book(int bookid,String name,String author,int quantity){
		this.bookid = bookid ;
		this.name = name;
		this.author = author;
		this.quantity = quantity ;		
	}
}
