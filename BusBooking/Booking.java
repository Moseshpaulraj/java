import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

class Booking{
	
	private long bookingId, userId ,driverId;
	private int busId;
	private short bordingPointId,dropingPointId;
	private Date date;
	private double amount;
	
	Booking(long bookingId,long userId,long driverId,int busId,short bordingPointId,short dropingPointId,Date date,double amount){
		this.bookingId=bookingId;
		this.userId=userId;
		this.driverId=driverId;
		this.busId=busId;
		this.bordingPointId=bordingPointId;
		this.dropingPointId=dropingPointId;
		this.date=date;
		this.amount=amount;
	}
	
	public long getBookingId(){
		return bookingId;
	}
	public long getUserId(){
		return userId;
	}
	public long getDriverId(){
		return driverId;
	}
	public int getBusId(){
		return busId;
	}
	public short getBordingPointId(){
		return bordingPointId;
	}
	public short getDropingPointId(){
		return dropingPointId;
	}
	public Date getDate(){
		return date;
	}
	public double getAmount(){
		return amount;
	}
	
	public void addPassanger(String name,short age,String gender,String seatNumber){
		String str ="INSERT INTO passangerdetails(booking_id,name,age,gender_id,seat_number) VALUES(?,?,?,(SELECT id FROM gender WHERE gender = ?),?);";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setLong(1,bookingId);
			statement.setString(2,name);
			statement.setShort(3,age);
			statement.setString(4,gender);
			statement.setString(5,seatNumber);
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}