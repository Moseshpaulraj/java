import java.util.Scanner;
import java.sql.*;
public class Main {
	public static final String FILENAME = "userData.txt";
	static Connection connection ;
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		try{
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/supermarket","moses","54321"); 
		}catch(Exception e){
			e.printStackTrace();
		}
        while (true){
            System.out.println("\n1. SignUp");
            System.out.println("2. Login");
			System.out.println("3. Admin Login");
            System.out.println("4. Exit");
            System.out.print("\nEnter your Choice : ");
            byte choice = scanner.nextByte();
            switch (choice){
               case 1:
					SuperMarket.createTable(connection);
                    AccountCreation.createAccount(connection);
                    break ;
               case 2:
					System.out.print("Enter your name :");
					String name = scanner.next();
					System.out.print("Enter password : ");
					String password = scanner.next();
					if(SuperMarket.login(connection,name,password)){
				a:
					while(true){
					SuperMarket.displayCategories();
					System.out.print("\nEnter your Choice : ");
					byte choice2 = scanner.nextByte();
					switch (choice2){
					case 1:
						SuperMarket.showProducts(connection,"Vegetables");
						System.out.print("Enter product name :");
						String product1 = scanner.next();
						System.out.print("Enter product quantity : ");
						byte quantity1 = scanner.nextByte();
						SuperMarket.purchaseProducts(connection,"Vegetables",product1,quantity1);
						break;
					case 2:
						SuperMarket.showProducts(connection,"Fruits");
						System.out.print("Enter product name :");
						String product2 = scanner.next();
						System.out.print("Enter product quantity : ");
						byte quantity2 = scanner.nextByte();
						SuperMarket.purchaseProducts(connection,"Fruits",product2,quantity2);
						break;
					case 3:
						SuperMarket.showProducts(connection,"Snacks");
						System.out.print("Enter product name :");
						String product3 = scanner.next();
						System.out.print("Enter product quantity : ");
						byte quantity3= scanner.nextByte();
						SuperMarket.purchaseProducts(connection,"Snacks",product3,quantity3);
						break;
					case 4:
						SuperMarket.showProducts(connection,"Groceries");
						System.out.print("Enter product name :");
						String product4 = scanner.next();
						System.out.print("Enter product quantity : ");
						byte quantity4 = scanner.nextByte();
						SuperMarket.purchaseProducts(connection,"Groceries",product4,quantity4);
						break ; 
					case 5:
						SuperMarket.showProducts(connection,"PersnalCare");
						System.out.print("Enter product name :");
						String product5 = scanner.next();
						System.out.print("Enter product quantity : ");
						byte quantity5 = scanner.nextByte();
						SuperMarket.purchaseProducts(connection,"PersnalCare",product5,quantity5);
						break;
					case 6:
						SuperMarket.currentUser = null ;
						break a;
					default:
						System.out.println("Invalid choice!");
					}
				}
			}
			break;
			case 3:
					System.out.print("Enter your name :");
					String adminName = scanner.next();
					System.out.print("Enter password : ");
					String adminPassword = scanner.next();
					if(SuperMarket.login(connection,adminName,adminPassword)){
				a:
					while(true){
					System.out.println("\n1. View Products");
					System.out.println("2. Add Products ");
					System.out.println("3. delete Products");
					System.out.println("4. Add Quantity");
					System.out.println("5. Change Price");
					System.out.println("6. logout");
					System.out.print("\nEnter your Choice : ");
					byte choice3 = scanner.nextByte();
					switch(choice3){
					case 1:
						SuperMarket.displayCategories();
						System.out.print("\nEnter your Choice : ");
						byte choice4 = scanner.nextByte();
						switch (choice4){
						case 1:
							SuperMarket.showProducts(connection,"Vegetables");
							break;
						case 2:
							SuperMarket.showProducts(connection,"Fruits");
							break;
						case 3:
							SuperMarket.showProducts(connection,"Snacks");
							break;
						case 4:
							SuperMarket.showProducts(connection,"Groceries");
							break ; 
						case 5:
							SuperMarket.showProducts(connection,"PersnalCare");
							break;
						case 6:
							break a;
						default:
							System.out.println("Invalid choice!");
						}
					case 2:
						SuperMarket.displayCategories();
						System.out.print("\nEnter your Choice : ");
						byte choice5 = scanner.nextByte();
						switch (choice5){
						case 1:
							SuperMarket.addProducts(connection,"Vegetables");
							break;
						case 2:
							SuperMarket.addProducts(connection,"Fruits");
							break;
						case 3:
							SuperMarket.addProducts(connection,"Snacks");
							break;
						case 4:
							SuperMarket.addProducts(connection,"Groceries");
							break ; 
						case 5:
							SuperMarket.addProducts(connection,"PersnalCare");
							break;
						case 6:
							break a;
						default:
							System.out.println("Invalid choice!");
						}
				/*	case 3:
						SuperMarket.displayCategories();
						System.out.print("\nEnter your Choice : ");
						byte choice2 = scanner.nextByte();
						switch (choice2){
						case 1:
							SuperMarket.deleteProducts(connection,Vegetables);
							break;
						case 2:
							SuperMarket.deleteProducts(connection,Fruits);
							break;
						case 3:
							SuperMarket.deleteProducts(connection,Snacks);
							break;
						case 4:
							SuperMarket.deleteProducts(connection,Groceries);
							break ; 
						case 5:
							SuperMarket.deleteProducts(connection,PersnalCare);
							break;
						case 6:
							break a;
						default:
							System.out.println("Invalid choice!");
						}
					case 4 :
						SuperMarket.displayCategories();
						System.out.print("\nEnter your Choice : ");
						byte choice2 = scanner.nextByte();
						switch (choice2){
						case 1:
							SuperMarket.addQuantity(connection,Vegetables);
							break;
						case 2:
							SuperMarket.addQuantity(connection,Fruits);
							break;
						case 3:
							SuperMarket.addQuantity(connection,Snacks);
							break;
						case 4:
							SuperMarket.addQuantity(connection,Groceries);
							break ; 
						case 5:
							SuperMarket.addQuantity(connection,PersnalCare);
							break;
						case 6:
							break a;
						default:
							System.out.println("Invalid choice!");
						}
					case 5 :
						SuperMarket.displayCategories();
						System.out.print("\nEnter your Choice : ");
						byte choice2 = scanner.nextByte();
						switch (choice2){
						case 1:
							SuperMarket.changePrice(connection,Vegetables);
							break;
						case 2:
							SuperMarket.changePrice(connection,Fruits);
							break;
						case 3:
							SuperMarket.changePrice(connection,Snacks);
							break;
						case 4:
							SuperMarket.changePrice(connection,Groceries);
							break ; 
						case 5:
							SuperMarket.changePrice(connection,PersnalCare);
							break;
						case 6:
							break a;
						default:
							System.out.println("Invalid choice!");
						}*/
					} 
				}
			}
			break;
			case 4:
				System.out.println("\n===================");
				System.out.println("WELCOME!!");
				System.out.println("===================");
				System.exit(0);
				break;
            default:
				System.out.println("Invalid choice!");
            }
        } 
    }
}