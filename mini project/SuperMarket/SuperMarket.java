import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

class SuperMarket{
	static String currentUser ; 
	
	public static void displayCategories(){
		System.out.println("\n1. Vegetables");
		System.out.println("2. Fruits ");
		System.out.println("3. Snacks");
		System.out.println("4. Groceries");
		System.out.println("5. PersonalCare");
		System.out.println("6. logout");
	}
	
	public static void createTable(Connection connection){
		String str1 ="CREATE TABLE IF NOT EXISTS users(username VARCHAR(30) NOT NULL,phone VARCHAR(12) NOT NULL, password VARCHAR(30) NOT NULL;";
		try{
		Statement statement = connection.createStatement();
		statement.executeUpdate(str1);
		System.out.println("TABLE CREATED SUCCESSFULLY");
		}catch(Exception e){
			System.out.println("ERROR IN TABLE CREATION");
		}
		String[] arr={"Vegetables","Fruits","Snacks","Groceries","PersonalCare"};
		for(String category : arr){
			try{
			String str2 ="CREATE TABLE IF NOT EXISTS ?(product VARCHAR(20) NOT NULL,price SHORT NOT NULL, quantity BYTE NOT NULL;";
			PreparedStatement statement = connection.prepareStatement(str2);
			statement.setString(1,category);
			statement.executeUpdate();
			System.out.println("TABLE CREATED SUCCESSFULLY");
			}catch(Exception e){
				System.out.println("ERROR IN TABLE CREATION");
				e.printStackTrace();
			}
		}
	}
	
	public static boolean login(Connection connection,String name,String password){
		try{
			String str ="SELECT * FROM users Where username = ?;";
			PreparedStatement ps = connection.prepareStatement(str);
			ps.setString(1,name);
			ResultSet rs =ps.executeQuery();
			if(rs.next()){
				String pw = rs.getString("password");
				if(password.equals(pw)){
					System.out.println("LOGIN SUCCESSFUL "+name+" !!!");
					currentUser = name;
					return true;
				}
			}else{
				System.out.println("USER NOT FOUND");
			}
		}
		catch(Exception e){
			System.out.println("ERROR IN LOGIN");
		}
		return false;
	}
	
	public static void showProducts(Connection connection,String categories){
		String str ="SELECT * FROM ? ;";
		try{
			PreparedStatement ps = connection.prepareStatement(str);
			ps.setString(1,categories);
			ps.executeUpdate();
			ResultSet rs =ps.executeQuery();
			byte i = 1;
			while(rs.next()){
				String product = rs.getString("product");
				short price = rs.getShort("price");
				byte quantity = rs.getByte("quantity"); 
				System.out.println(i++ +"."+product+" : "+price+"$ :"+quantity);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void purchaseProducts(Connection connection,String categories,String product,byte quantity){
		String str = "SELECT quantity FROM ? WHERE product =?";
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(str);
	        preparedStatement.setString(1, categories);
	        preparedStatement.setString(2, product);
            ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()){
				byte availableQuantity = rs.getByte("quantity");
				if(quantity<=availableQuantity){
					int newQuantity = availableQuantity - quantity;
					String str2="UPDATE "+categories+"SET quantity=? WHERE product =? ";
					PreparedStatement preparedStatement2 = connection.prepareStatement(str2);
					preparedStatement2.setByte(1, (byte)newQuantity);
					preparedStatement2.setString(2, product);
					preparedStatement2.executeUpdate();
					System.out.println("purchase sucessful "+currentUser+"!!!");
				}else{
					System.out.println("out of stock");
				}
			}else{
				System.out.println("product not found");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static void addProducts(Connection connection,String categories){
		try{
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter product name :");
			String product = scanner.next();
			System.out.print("Enter product price :");
			short price = scanner.nextShort();
			System.out.print("Enter product quantity :");
			byte quantity = scanner.nextByte();
			String str = "INSERT INTO ?(product,price,quantity)VALUES(?,?,?);";
			PreparedStatement ps = connection.prepareStatement(str);
			ps.setString(1,categories);
			ps.setString(2,product);
			ps.setShort(3,price);
			ps.setByte(4,quantity);
			ps.executeUpdate();
			System.out.println("\nPRODUCT ADDED SUCCESSFULLY !");					
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}