import java.util.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

class Taxi{
	private int taxiId ;
	private String taxiName ;
	private String currentLocation ;
	private boolean isAvailable ;
	private LocalDateTime availableTime ;
	private double earnings ;
	
	public Taxi(){
	}
	
	public Taxi(int taxiId,String taxiName,String currentLocation,boolean isAvailable,LocalDateTime availableTime){
		this.taxiId = taxiId ;
		this.taxiName = taxiName ;
		this.currentLocation = currentLocation ;
		this.isAvailable = isAvailable;
		this.availableTime = availableTime;
	}
	
	public String getTaxiName(){
		return taxiName;
	}
	
	public int getTaxiId(){
		return taxiId;
	}
	
	public String getCurrentLocation(){
		return currentLocation;
	}
	
	public boolean getIsAvailable(){
		return isAvailable;
	}

	public LocalDateTime getAvailableTime(){
		return availableTime;
	}
	
	public void updateTaxiDetails(int id,String dropLocation,boolean isavailable,LocalDateTime availableTime){
		String str ="UPDATE taxi_details SET location = ? , isavailable = ? ,availabletime = ? where id = ?;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,dropLocation);
			statement.setBoolean(2,isavailable);
			statement.setTimestamp(3,Timestamp.valueOf(availableTime));
			statement.setInt(4,id);
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}