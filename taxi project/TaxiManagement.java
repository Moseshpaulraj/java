import java.util.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class TaxiManagement{
	private List<Taxi> taxis ;
	private List<Trip> trips ;
	private List<Driver> drivers ;
	
	public TaxiManagement(){
		allTaxis();
		allDrivers();
		allTrips();
	}
	
	public void allTaxis(){
		taxis = new ArrayList<Taxi>();
		String str ="SELECT * FROM taxi_details ;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()){
				int id = resultset.getInt("id");
				String taxiname = resultset.getString("name");
				String currentLocation = resultset.getString("location");
				boolean isAvailable = resultset.getBoolean("isavailable");
				LocalDateTime availableTime = resultset.getTimestamp("availabletime").toLocalDateTime();
				taxis.add(new Taxi(id,taxiname,currentLocation,isAvailable,availableTime));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public List<Taxi> getAvailableTaxis(String pickupLocation,LocalDateTime pickupTime){
		List<Taxi> availableTaxis = new ArrayList<Taxi>();
		for(Taxi taxi : taxis){
			int sourceTime = (Location.calculateDistance(pickupLocation,taxi.getCurrentLocation()))/100;
			if(taxi.getAvailableTime().isBefore(pickupTime) && ChronoUnit.MINUTES.between(LocalDateTime.now(), pickupTime) >= sourceTime){
				availableTaxis.add(taxi);
			}
		}
		return availableTaxis;
	}
	public void bookTaxi(String pickupLocation,String dropLocation,LocalDateTime pickupTime){
		Taxi taxi = new Taxi();
		List<Taxi> availableTaxis = getAvailableTaxis(pickupLocation,pickupTime);
    //    Collections.sort(availableTaxis, (taxi1, taxi2) -> Integer.compare(taxi1.getAvailableTime(), taxi2.getAvailableTime()));
		if(availableTaxis.size() >=1){
			Taxi bookedTaxi = availableTaxis.get(0);
			Trip trip = new Trip();
			int tripTime = (Location.calculateDistance(pickupLocation,dropLocation))/100;
			LocalDateTime dropTime = pickupTime.plusMinutes(tripTime);
			trip.addTrip(User.currentUserId,bookedTaxi.getTaxiId(),pickupLocation,dropLocation);
			bookedTaxi.updateTaxiDetails(bookedTaxi.getTaxiId(),dropLocation,false,dropTime);
		}
	}
	public void getTaxiDetails(){
		for(Taxi taxi : taxis){
			System.out.println(taxi.getTaxiName());
			System.out.println(taxi.getCurrentLocation());
			System.out.println(taxi.getAvailableTime());
		}
	}
	public void allTrips(){
		trips = new ArrayList<Trip>();
		String str ="SELECT * FROM booking_details ;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()){
				int id = resultset.getInt("id");
				int userId = resultset.getInt("user_id");
				int taxiId = resultset.getInt("taxi_id");
				String fromLocation = resultset.getString("fromlocation");
				String toLocation = resultset.getString("tolocation");
				trips.add(new Trip(id,userId,taxiId,fromLocation,toLocation));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void displayTripDetails(){
		for(Trip trip : trips){
			System.out.println(trip.getTripId());
			System.out.println(trip.getUserId());
			System.out.println(trip.getTaxiId());
			System.out.println(trip.getFromLocation());
			System.out.println(trip.getToLocation());
			
		}
	}
	public int addTaxi(String name,String location,boolean isavailable,LocalDateTime availabletime){
		String str ="INSERT INTO taxi_details (name,location,isavailable,availabletime) VALUES (?,?,?,?) RETURNING id ;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,name);
			statement.setString(2,location);
			statement.setBoolean(3,isavailable);
			statement.setTimestamp(4,Timestamp.valueOf(availabletime));
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()){
				int taxiId = resultset.getInt("id");
				taxis.add(new Taxi(taxiId,name,location,isavailable,availabletime));
				return taxiId ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1 ;
	}
	public void allDrivers(){
		drivers = new ArrayList<Driver>();
		String str ="SELECT * FROM driver_details ;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()){
				int id = resultset.getInt("id");
				String driverName = resultset.getString("name");
				String licenceno = resultset.getString("licenceno");
				String phoneno = resultset.getString("phoneno");
				int taxiId = resultset.getInt("taxi_id");
				drivers.add(new Driver(id,driverName,licenceno,phoneno,taxiId));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void addDriver(String name,String licenceno,String phoneno,int taxi_id){
		String str ="INSERT INTO driver_details (name,licenceno,phoneno,taxi_id) VALUES (?,?,?,?) RETURNING id;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,name);
			statement.setString(2,licenceno);
			statement.setString(3,phoneno);
			statement.setInt(4,taxi_id);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()){
				int driverId = resultset.getInt("id");
				drivers.add(new Driver(driverId,name,licenceno,phoneno,taxi_id));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void displayDriverDetails(){
		for(Driver driver : drivers){
			System.out.println(driver.getDriverId());
			System.out.println(driver.getDriverName());
			System.out.println(driver.getLicenceNo());
			System.out.println(driver.getPhoneNo());
			System.out.println(driver.getTaxiId());
			
		}
	}
	
	public void displayBookingHistory(){
		for(Trip trip : trips){
			if(trip.getUserId() == User.currentUserId){
				System.out.println("Trip Id      : "+trip.getTripId());
				System.out.println("Taxi Id      : "+trip.getTaxiId());
				System.out.println("FromLocation : "+trip.getFromLocation());
				System.out.println("ToLocation   : "+trip.getToLocation());
			}
		}
	}
}