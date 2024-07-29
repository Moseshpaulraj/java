import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Main{
	//static String userName ;
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
	a :	while(true){
			System.out.println("\n1 -> Signup \n2 -> Login \n3 -> Exit");
			System.out.print("\nEnter your Option : ");
			String choice =scanner.next();
			switch(choice){
			case "1":
				System.out.print("\nEnter Your Name : ");
				String name =scanner.next();
				System.out.print("\nEnter Your PhoneNo : ");
				String phone =scanner.next();
				System.out.print("\nEnter Your Password : ");
				String password =scanner.next();
				User user = new User(name,phone,password,false);
				user.register();
				break;
			case "2":
				System.out.print("\nEnter Your UserName : ");
				String userName =scanner.next();
				System.out.print("\nEnter Your Password : ");
				password =scanner.next();
				String loginType = User.login(userName,password);
				if("user".equals(loginType)){
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("LOGIN SUCCESSFUL!!!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
					TaxiManagement taxiManagement = new TaxiManagement();
				b:	while(true){
						System.out.println("\n1 -> BOOK TAXI\n2 -> BOOKING DETAILS\n3 -> BOOKING HISTORY\n4 -> LOGOUT ");
						System.out.print("\nEnter your Option : ");
						choice = scanner.next();
						switch(choice){
						case "1":
							Location.displayMap();
							System.out.print("\nEnter PickupLocation : ");
							String pickupLocation =scanner.next();
							System.out.print("\nEnter DropLocation : ");
							String dropLocation =scanner.next();
							System.out.print("\nEnter PickupTime(HHMM): ");
							int pickuptime =scanner.nextInt();
							LocalDateTime pickupTime = LocalDateTime.now().withHour(pickuptime / 100).withMinute(pickuptime % 100);
							taxiManagement.bookTaxi(pickupLocation,dropLocation,pickupTime);
							break;
						case "2":
						//	bookingDetails();
						case "3":
							taxiManagement.displayBookingHistory();
							break;
						case "4":
							System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("LOGOUT SUCCESSFUL!!!");
							System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
							break b;
						default :
							System.out.println("Enter a valid Option");
						}
					}
				}else if("admin".equals(loginType)){
					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("LOGIN SUCCESSFUL!!!");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
					TaxiManagement taxiManagement = new TaxiManagement();
				c:	while(true){
						System.out.println("\n1 -> TAXI DETAILS \n2 -> TAXI HISTORY \n3 -> DRIVER DETAILS \n4 --> USER DETAILS \n5 -> LOGOUT");
						System.out.print("\nEnter your Option : ");
						choice = scanner.next();
						switch(choice){
						case "1":
							taxiManagement.getTaxiDetails();
						d:	while(true){
							System.out.println("\n1 -> ADD TAXI \n2 -> REMOVE TAXI \n3 -> UPDATE TAXI \n4 --> BACK");
							System.out.print("\nEnter your Option : ");
							choice = scanner.next();
							switch(choice){
							case "1":
								System.out.print("\nEnter taxi name : ");
								String taxiName =scanner.next();
								System.out.print("\nEnter Location : ");
								String location =scanner.next();
								System.out.print("\nEnter Driver Name : ");
								String driverName =scanner.next();
								System.out.print("\nEnter Licence.no : ");
								String licenceNo =scanner.next();
								System.out.print("\nEnter Phone.no : ");
								String phoneNo =scanner.next();
								int taxiId = taxiManagement.addTaxi(taxiName,location,true,LocalDateTime.now());
								taxiManagement.addDriver(driverName,licenceNo,phoneNo,taxiId);
								System.out.println("TAXI ADDED SUCCESSFULLY !!!");
								break;
							case "2":
							//	taxiManagement.removeTaxi();
							case "3":
							//	taxiManagement.updateTaxi();
							case "4":
								break d;
							default :
								System.out.println("Enter a valid Option");
								}
							}
						case "2":
							taxiManagement.displayTripDetails();
							break ;
						case "3":
							taxiManagement.displayDriverDetails();
							break ;
						case "4":
						//	userDetails();
						case "5":
							break c;
						default :
							System.out.println("Enter a valid Option");
					}
					}
				}
				break ;
			case "3":
				System.out.println("EXITING......");
				break a;
			default :
				System.out.println("Enter a valid Option");
			}
		}
	}
}