import java.sql.*;
class Trip{
	private int tripId ;
	private int userId ;
	private int taxiId ;
	private String fromLocation ;
	private String toLocation ;
	
	public Trip(){
		
	}
	
	public Trip(int tripId,int userId,int taxiId,String fromLocation,String toLocation){
		this.tripId = tripId;
		this.userId = userId;
		this.taxiId = taxiId;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
	}
	
	public int getTripId(){
		return tripId ;
	}
	
	public int getUserId(){
		return userId ;
	}
	
	public int getTaxiId(){
		return taxiId ;
	}
	
	public String getFromLocation(){
		return fromLocation ;
	}
	public String getToLocation(){
		return toLocation ;
	}
	
	public void addTrip(int userId , int taxiId ,String fromLocation,String toLocation){
	String str ="INSERT INTO booking_details(user_id,taxi_id,fromLocation,toLocation) VALUES(?,?,?,?);";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setInt(1,userId);
			statement.setInt(2,taxiId);
			statement.setString(3,fromLocation);
			statement.setString(4,toLocation);
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}