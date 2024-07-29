import java.util.Scanner;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.sql.Date;

class Main{
	
	private static final byte SIGNUP = 1,LOGIN = 2,EXIT = 3 ; 
	private static final byte BOOK_BUS = 1,BOOKING_DETAILS = 2 ,BOOKING_HISTORY = 3 , SIGNOUT = 4 ; 
	private static final byte BUS_DETAILS = 1, DRIVER_DETAILS = 2, USER_DETAILS = 4, ADMIN_DETAILS = 5, LOGOUT = 6;
	private static final byte ADD_NEW_BUS = 1, UPDATE_BUS =2 ,DELETE_BUS = 3,ADD_NEW_DRIVER =1,All_DRIVER_DETAILS =2 ,							DELETE_DRIVER =3 ,ADD_NEW_ADMIN =1,ALL_ADMIN_DETAILS=2,REMOVE_ADMIN= 3,BACK = 4;
	
	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		byte choice = 0 ;
		while(true){
			System.out.println("\n1 --> SIGNUP \n2 --> LOGIN \n3 --> EXIT ");
			System.out.print("Enter Your Option : ");
			if(scanner.hasNextByte()){
				choice = scanner.nextByte();
			}else{
				System.out.println("Enter Valid Option !!!");
				break ;
			}
			UserAuthentication userAuth = new UserAuthentication();
			switch(choice){
				
				case SIGNUP :
					System.out.println("Enter your Name    : ");
					String name = scanner.next();
					if(!Validation.isValidName(name)){
						System.out.println("Enter Valid Name !!!");
						break ;
					}
					
					System.out.println("Enter Phone Number : ");
					String phoneNumber = scanner.next();
					if(!Validation.isValidPhoneNo(phoneNumber)){
						System.out.println("Enter Valid phoneNumber !!!");
						break ;
					}
					
					System.out.println("Create Password    : ");
					String password = scanner.next();
					if(!Validation.isValidPassword(password)){
						System.out.println("Enter Valid password !!!");
						break ;
					}
					userAuth.signup(name,phoneNumber,password);
					break ;
					
				case LOGIN :
					System.out.println("Enter Phone Number : ");
					phoneNumber = scanner.next();
					if(!Validation.isValidPhoneNo(phoneNumber)){
						System.out.println("Enter Valid phoneNumber !!!");
						break ;
					}
					System.out.println("Enter Password     : ");
					password = scanner.next();
					if(!Validation.isValidPassword(password)){
						System.out.println("Enter Valid password !!!");
						break ;
					}
					
					if(userAuth.signIn(phoneNumber,password)){
						User user = UserContext.getUser();
						BusManagement busManagement = new BusManagement();
							if(UserContext.getUser().getTypeId()==(short)1){
customer:						while(true){
									System.out.println("1 --> BOOK BUS \n2 --> BOOKING DETAILS \n3 --> BOOKING HISTORY \n4 --> LOGOUT ");
									System.out.print("Enter Your Option : ");
									if(scanner.hasNextByte()){
										choice = scanner.nextByte();
									}else{
										System.out.println("Enter Valid Option !!!");
										break;
									}
									
									switch(choice){
										
										case BOOK_BUS :
											Map.displayMap();
											System.out.println("Enter PickupLocation : ");
											String pickupLocation = scanner.next();
											System.out.println("Enter DropLocation");
											String dropLocation = scanner.next();
											SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
											System.out.println("Enter Date (YYYY-MM-DD) : ");
											String inputDate = scanner.next();
											if(!Validation.isValidDate(inputDate)){
												System.out.println("Enter Valid Date !!!");
												break ;
											}
											try{
												java.util.Date utilDate = dateFormat.parse(inputDate);
												Date date = new Date(utilDate.getTime());
												String currentDateStr = dateFormat.format(new java.util.Date());
												java.util.Date currentDate =dateFormat.parse(currentDateStr);
												if((utilDate.compareTo(currentDate)>= 0) && busManagement.hasAvailableBus(pickupLocation,dropLocation)){
												
												System.out.println("Enter BusId : ");
												int busId = scanner.nextInt();
												
												Bus bus = busManagement.getBus(busId);
												bus.getBookedSeats(date);
												System.out.println("\nSelect seats (max 5)(no,no,no,..): ");
												String selectedSeats = scanner.next().toUpperCase();
												String[] selectedSeatArray = selectedSeats.split(",");
												if(!bus.validateSelectedSeats(selectedSeatArray)){
													System.out.println("SELECT VALID SEATS ");
													break ;
												}
												Map map = new Map();
												map.displayStops(pickupLocation);
												
												System.out.println("Enter BordingPoint : ");
												String bordingPoint = scanner.next();
												short bordingPointId = map.getLocationId(bordingPoint);
												map.displayStops(dropLocation);
												
												System.out.println("Enter DropingPoint : ");
												String dropingPoint = scanner.next();
												short dropingPointID = map.getLocationId(dropingPoint);
												
												int distance = map.getDistance(bordingPoint,dropingPoint);
												double amount = bus.getTotalAmount(selectedSeatArray,distance);
												
												Long driverId =bus.getDriverId();
												Booking booking = user.addBooking(busId,driverId,bordingPointId,dropingPointID,date,amount);
												
												for(byte i=0;i<selectedSeatArray.length;i++){
													String seatNumber = selectedSeatArray[i];
													System.out.println("Enter passanger Name : ");
													String passangerName = scanner.next();
													if(Validation.isValidName(passangerName)){
														System.out.println("Enter Age :");
														short age = scanner.nextShort();
														if(1<age && age<100){
															System.out.println("Gender(male/female/others) : ");
															String gender = scanner.next().toLowerCase();
															if("male".equals(gender)||"female".equals(gender)||"others".equals(gender)) {
																booking.addPassanger(passangerName,age,gender,seatNumber);
															}else {
																i--;
																System.out.println("Enter Valid Gender!!!! ");
															}
														}else{
															i--;
															System.out.println("Enter Valid Age!!!! ");
														}
													}else {
														i--;
														System.out.println("Enter Valid name !!!! ");
														}
													}
												}
											}catch(ParseException e){
												System.out.println("Enter a valid Date in Format YYYY-MM-DD");
											}
										break ;
										
										case BOOKING_DETAILS :
											System.out.println("BOOKING DETAILS : ");
											user.getBookingDetails();
											break ;
										
										case BOOKING_HISTORY :
											System.out.println("BOOKING HISTORY : ");
											user.getBookingHistory();
											break ;
										
										case SIGNOUT :
											break customer ;
										default :
										System.out.println("ENTER VALID OPTION !!! ");
									}
								}
							}else{
					admin:	  	while(true){
									User admin = UserContext.getUser();
									System.out.println("\n1 --> BUS DETAILS \n2 --> DRIVER DETAILS \n3 --> BOOkING HISTORY \n4 --> USER DETAILS \n5 --> ADMIN DETAILS \n6 --> LOGOUT");
									System.out.print("Enter Your Option : ");
									if(scanner.hasNextByte()){
										choice = scanner.nextByte();
									}else{
										System.out.println("Enter Valid Option !!!");
										break ;
									}
									
									switch(choice){

										case BUS_DETAILS :
										busManagement.displayBusDetails();
							bus:		while(true){
											System.out.println("\n1 --> ADD NEW BUS \n2 --> UPDATE BUS \n3 --> DELETE BUS \n4 --> BACK ");
											System.out.print("Enter Your Option : ");
											if(scanner.hasNextByte()){
												choice = scanner.nextByte();
											}else{
												System.out.println("Enter Valid Option !!!");
												break ;
											}
											switch(choice){
												case ADD_NEW_BUS :
												System.out.print("Enter RegisterNumber : ");
												String reg_no = scanner.next();
												System.out.print("is A/C Bus :");
												boolean has_ac = scanner.nextBoolean();
												System.out.print("busSeat Type :");
												String type = scanner.next();
												System.out.print("Current location :");
												String currentLocation = scanner.next();
												boolean hasavailableDrivers = admin.hasAvailableDrivers();
												
												if(hasavailableDrivers){
													System.out.print("Enter Driver Id : ");
													int driverId = scanner.nextInt();
													System.out.print("Enter Route id : ");
													Short routeId = scanner.nextShort();
													System.out.print("Enter Departure Time : ");
													String inputTime = scanner.next();
													
													DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
													LocalTime dep_time = LocalTime.parse(inputTime, formatter);
													System.out.print("Enter Arival Time : ");
													inputTime = scanner.next();
													LocalTime arival_time = LocalTime.parse(inputTime, formatter);
													busManagement.addNewBus(reg_no,has_ac,type,currentLocation,driverId,routeId,dep_time,arival_time);
												}else{
													System.out.println("no drivers available");
												}
												break ;
												
												case UPDATE_BUS :
												System.out.print("Enter Bus Id : ");
												int busId = scanner.nextInt();
												break ;
												
												case DELETE_BUS :
												System.out.print("Enter Bus Id : ");
												busId = scanner.nextInt();
												busManagement.deleteBus(busId);
												break ;
												
												case BACK :
													break bus ;
												default :
													System.out.println("ENTER VALID OPTION !!!");
											}
										}
										break ;
										
										case DRIVER_DETAILS :
driver:										while(true){
												System.out.println("\n1 --> ADD NEW DRIVER\n2 --> All DRIVER DETAILS\n3 --> DELETE DRIVER\n4 --> BACK ");
												System.out.print("Enter Your Option : ");
												if(scanner.hasNextByte()){
													choice = scanner.nextByte();
												}else{
													System.out.println("Enter Valid Option !!!");
													break ;
												}
												switch(choice){
													case ADD_NEW_DRIVER :
														System.out.print("Enter Driver Name : ");
														name = scanner.next();
														if(!Validation.isValidName(name)){
															System.out.println("Enter Valid Name !!!");
															break ;
														}
														System.out.print("Enter phoneNumber : ");
														phoneNumber = scanner.next();
														System.out.print("Enter LicenceNumber : ");
														String licenceNumber = scanner.next();
														admin.addDriver(name,phoneNumber,licenceNumber,(short)3);
														break ;
														
													case All_DRIVER_DETAILS :
														System.out.print("   DRIVER DETAILS    ");
														admin.displayAllDrivers();
														break ;
														
													case DELETE_DRIVER :
														System.out.print("Enter Driver ID : ");
														long driverId = scanner.nextLong();
														admin.removeDriver(driverId);
														break ;
														
													case BACK :
														break driver ; 
														
													default :
														System.out.println("ENTER VALID OPTION !!!");
												}
											}
										break ;
											
										case BOOKING_HISTORY :
											System.out.print("Enter userId Id : ");
											long userId = scanner.nextLong();
											admin.getBookingHistory();
											break;
											
										case USER_DETAILS :
											System.out.println("User details : ");
											admin.getUserDetails();
											break;
											
										case ADMIN_DETAILS :
administrator:								while(true){
												System.out.println("1 --> ADD NEW ADMIN\n2 --> ALL ADMIN DETAILS \n3 --> REMOVE ADMIN \n4 --> BACK ");
												System.out.print("Enter Your Option : ");
												if(scanner.hasNextByte()){
														choice = scanner.nextByte();
												}else{
														System.out.println("Enter Valid Option !!!");
														break ;
												}
												switch(choice){
											
												case ADD_NEW_ADMIN :
												
													System.out.println("Enter Admin Name   : ");
													name = scanner.next();
													if(!Validation.isValidName(name)){
														System.out.println("Enter Valid Name !!!");
														break ;
													}
													System.out.println("Enter Phone Number : ");
													phoneNumber = scanner.next();
													if(!Validation.isValidPhoneNo(phoneNumber)){
														System.out.println("Enter Valid phoneNumber !!!");
														break ;
													}
													System.out.println("Create Password    : ");
													password = scanner.next();
													if(!Validation.isValidPassword(password)){
														System.out.println("Enter Valid password !!!");
														break ;
													}
													admin.addNewAdmin(name,phoneNumber,password);
													break ;
												
													case ALL_ADMIN_DETAILS :
														System.out.println(" ADMIN DETAILS ");
														admin.displayAdminDetails();
														break ;
														
													case REMOVE_ADMIN :
														System.out.println("Enter Admin ID : ");
														long adminId = scanner.nextLong();
														admin.removeAdmin(adminId);
														break ;
												
													case BACK :
														break administrator ;
													default :
														System.out.println("ENTER VALID OPTION !!!");
												}
											}
											break ;
										
										case LOGOUT :
											break admin ; 
										
										default :
											System.out.println("ENTER VALID OPTION !!!");
									} 
								}
							}
					}else{
						System.out.println("invalid phoneNumber or password");
					}
					break ; 
				case EXIT :
					System.out.println("Exiting....");
					System.exit(0);
				default :
					System.out.println("Enter Valid Input !!");
			}
		}
	}
}