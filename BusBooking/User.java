import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

class User{

	private long userId;
	private String name ,phoneNumber,password ;
	private short typeId ,statusId;
	
	public long getUserId(){
		return userId ;
	}
	
	public String getName(){
		return name ;
	}
	
	public String getPhoneNumber(){
		return phoneNumber ;
	}
	
	public short getTypeId(){
		return typeId ;
	}
	
	public short getStatusId(){
		return statusId ;
	}
	
	
	public User(long userId,String name,String phoneNumber,short typeId,short statusId){
		this.userId = userId;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.typeId = typeId;
		this.statusId = statusId;
	}
	
	public Booking addBooking(int busId,long driverId,short bordingPointId,short dropingPointId,Date date,double amount){
		long bookingId = -1;
		Booking booking = null;
		String str ="INSERT INTO bookingdetails(user_id,bus_id,driver_id,bording_point,droping_point,booking_date,amount) VALUES(?,?,?,?,?,?,?) RETURNING id ;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setLong(1,userId);
			statement.setInt(2,busId);
			statement.setLong(3,driverId);
			statement.setShort(4,bordingPointId);
			statement.setShort(5,dropingPointId);
			statement.setDate(6,date);
			statement.setDouble(7,amount);
			ResultSet resultset =statement.executeQuery();
			if(resultset.next()){
				bookingId = resultset.getLong("id");
				booking =new Booking(bookingId,userId,driverId,busId,bordingPointId,dropingPointId,date,amount);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return booking;
	}
	
	public boolean hasAvailableDrivers(){
		String str = "SELECT dd.user_id , u.name, u.phone_number, dd.licence_number FROM DriverDetails dd JOIN Users u ON dd.user_id = u.id LEFT JOIN BusDriverMapping bdm ON dd.user_id = bdm.driver_id WHERE bdm.bus_id IS NULL;";
		boolean result = false ;
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getLong("user_id"));
				System.out.println(resultSet.getString("name"));
				System.out.println(resultSet.getString("phone_number"));
				System.out.println(resultSet.getString("licence_number"));
				result = true ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public void addDriver(String name,String phoneNumber,String liecenceNumber,short type){
		String str ="INSERT INTO users(name,phone_number,type_id,status_id) VALUES(?,?,?,1)RETURNING id;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,name);
			statement.setString(2,phoneNumber);
			statement.setShort(3,type);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				long userId = resultSet.getLong("id");
				str ="INSERT INTO driverdetails(user_id,licence_number) VALUES(?,?);";
				PreparedStatement statement1 =connection.prepareStatement(str);
				statement1.setLong(1,userId);
				statement1.setString(2,liecenceNumber);
				statement1.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void removeDriver(long driverId){
		String str ="UPDATE users SET status_id = 2 WHERE type_id = 3 AND id = ?;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setLong(1,driverId);
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void getUserDetails(){
		String str = "SELECT id ,name , phone_number FROM Users WHERE type_id = (SELECT id FROM UserType WHERE type = 'customer');";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				System.out.print("\nID : "+resultSet.getLong("id"));
				System.out.print("  NAME : "+resultSet.getString("name"));
				System.out.print("  PHONE : "+resultSet.getString("phone_number"));
				System.out.print("\n------------------------------------------------------");

			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void displayAllDrivers() {
		String str = "SELECT user_id , name, phone_number, licence_number FROM DriverDetails JOIN Users ON user_id = id ;" ;
		try{Connection connection = DBConnection.getConnection();
		PreparedStatement statement =connection.prepareStatement(str);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				System.out.print("\nID : "+resultSet.getLong("user_id"));
				System.out.print("  NAME : "+resultSet.getString("name"));
				System.out.print("\nPHONE : "+resultSet.getString("phone_number"));
				System.out.print("  LICENCE : "+resultSet.getString("licence_number"));
				System.out.print("\n----------------------------------------------------");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addNewAdmin(String name,String phoneNumber,String password){
		String str ="INSERT INTO users(name,phone_number,type_id,status_id) VALUES(?,?,(SELECT id FROM usertype WHERE type = ?),(SELECT id FROM userstatus WHERE status = ?))RETURNING id;";
			try{
				Connection connection = DBConnection.getConnection();
				PreparedStatement statement =connection.prepareStatement(str);
				statement.setString(1,name);
				statement.setString(2,phoneNumber);
				statement.setString(3,"admin");
				statement.setString(4,"ACTIVE");
				ResultSet resultSet = statement.executeQuery();
				if(resultSet.next()){
					long userId = resultSet.getLong("id");
					str ="INSERT INTO userpasswordmapping(user_id,password) VALUES(?,?);";
					PreparedStatement statement1 =connection.prepareStatement(str);
					statement1.setLong(1,userId);
					statement1.setString(2,password);
					statement1.executeUpdate();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void displayAdminDetails(){
			String str = "SELECT id,name,phone_number FROM users WHERE type_id = (SELECT id FROM UserType WHERE type = 'admin');";
			try{
				Connection connection = DBConnection.getConnection();
				PreparedStatement statement =connection.prepareStatement(str);
				ResultSet resultSet = statement.executeQuery();
				while(resultSet.next()) {
					System.out.print("ID : "+resultSet.getLong("id"));
					System.out.print(" NAME : "+resultSet.getString("name"));
					System.out.print(" PHONE : "+resultSet.getString("phone_number"));
					System.out.print("\n----------------------------------------------------");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void removeAdmin(long adminId){
			String str ="UPDATE users SET status_id = 2 WHERE type_id = 2 AND id = ?;";
			try{
				Connection connection = DBConnection.getConnection();
				PreparedStatement statement =connection.prepareStatement(str);
				if(adminId==170){
				statement.setLong(1,adminId);
				statement.executeUpdate();
				}else{
					System.out.println("YOU DONT HAVE PERMISION TO DELETE THIS ADMIN");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		public void getBookingDetails(){
		String str = """
					SELECT 
						bd.id,
						bd.bus_id,
						bp.name AS bording_point,
						dp.name AS droping_point,
						bd.booking_date,
						bd.amount,
						brm.departure_time 
					FROM 
						BookingDetails bd 
					JOIN 
						BusRouteMapping brm ON bd.bus_id = brm.bus_id 
					JOIN 
						BusDetails b ON bd.bus_id = b.id 
					JOIN 
						PickupAndDrop bpd ON bd.bording_point = bpd.id 
					JOIN 
						PickupAndDrop dpd ON bd.droping_point = dpd.id 
					JOIN 
						Locations bp ON bpd.stops = bp.id 
					JOIN 
						Locations dp ON dpd.stops = dp.id 
					WHERE 
						bd.user_id = ? 
						AND (
							(bd.booking_date > CURRENT_DATE) 
							OR (bd.booking_date = CURRENT_DATE AND brm.arival_time > CURRENT_TIME)
						) 
					ORDER BY 
						bd.booking_date, 
						brm.departure_time;
					""";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setLong(1,userId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				System.out.println("--------------------------------------------------------");
				System.out.println("Booking id : " + resultSet.getLong("id"));
				System.out.println("Bus id : " + resultSet.getInt("bus_id"));
				System.out.println("Boarding Point : " + resultSet.getString("bording_point"));
				System.out.println("Droping Point : " + resultSet.getString("droping_point"));
				System.out.println("Date : " + resultSet.getDate("booking_date"));
				System.out.println("Amount : " + resultSet.getDouble("amount"));
				System.out.println("Departure Time : " + resultSet.getTime("departure_time"));
				System.out.println("--------------------------------------------------------");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
		public void getBookingHistory(){
		String str = """
				SELECT 
					bd.id ,
					bd.bus_id,
					bd.bording_point, 
					bd.droping_point, 
					bd.booking_date,
					bd.amount,brm.departure_time 
				FROM 
					BookingDetails bd 
				JOIN 
					BusRouteMapping brm ON bd.bus_id = brm.bus_id 
				JOIN 
					BusDetails b ON bd.bus_id = b.id 
				WHERE 
					bd.user_id = ? AND ( (bd.booking_date < CURRENT_DATE) OR  (bd.booking_date = CURRENT_DATE AND brm.arival_time < CURRENT_TIME)) 
					ORDER BY bd.booking_date, brm.departure_time;
					""";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setLong(1,userId);
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()){
				System.out.println("--------------------------------------------------------");
				System.out.print("Booking id : " + resultSet.getLong("id"));
				System.out.println("  Bus id : " + resultSet.getInt("bus_id"));
				System.out.print("Boarding Point : " + resultSet.getShort("bording_point"));
				System.out.println("  Droping Point : " + resultSet.getShort("droping_point"));
				System.out.print("Date : " + resultSet.getDate("booking_date"));
				System.out.println("  Amount : " + resultSet.getDouble("amount"));
				System.out.println("Departure Time : " + resultSet.getTime("departure_time"));
				System.out.println("--------------------------------------------------------");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}