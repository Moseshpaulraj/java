import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;

class Bus {
	private int busId ;
	private String registerNumber ;
	private boolean hasAc ;
	private short statusId ;
	private short currentLocationId ;
	
	
	
	Bus(int busId,String registerNumber,boolean hasAc,short statusId,short currentLocationId){
		this.busId = busId;
		this.registerNumber = registerNumber;
		this.hasAc = hasAc;
		this.statusId = statusId;
		this.currentLocationId = currentLocationId;
	}
	
	public int getBusId(){
		return busId;
	}
	
	public String getRegisterNumber(){
		return registerNumber;
	}
	
	public boolean getHasAc(){
		return hasAc;
	}
	
	public short getStatusId(){
		return statusId;
	}
	
	public short getCurrentLocationId(){
		return currentLocationId;
	}
	
	private List<String> bookedSeats ;
	private List<String> totalSeats ;
	
	public void getBookedSeats(Date date ){
		bookedSeats= new ArrayList<String>();
		String str = "SELECT seat_number FROM BookingDetails bd JOIN passangerDetails pd ON bd.id = pd.booking_id WHERE bd.booking_date = ? AND bd.bus_id = ?;";
		try{
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(str);
		statement.setDate(1,date);
		statement.setInt(2,busId);
		ResultSet resultset = statement.executeQuery();
		while(resultset.next()){
			String seat = resultset.getString("seat_number"); 
			bookedSeats.add(seat);
		}
		getTotalSeats();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getTotalSeats(){
		totalSeats = new ArrayList<String>();
		String str = "SELECT Seats.seat_number FROM BusSeatGroupMappings JOIN Seats ON BusSeatGroupMappings.group_id = Seats.group_id WHERE BusSeatGroupMappings.bus_id = ?;";
		try{
		Connection connection = DBConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(str);
		statement.setInt(1,busId);
		ResultSet resultset = statement.executeQuery();
		while(resultset.next()){
			String seat = resultset.getString("seat_number"); 
			totalSeats.add(seat);
		}
		displayAvailableSeats(totalSeats,bookedSeats);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void displayAvailableSeats(List<String> totalSeats, List<String> bookedSeats){
		String redColor = "\u001B[31m";
        String resetColor = "\u001B[0m";
        for (String seat : totalSeats) {
            if (bookedSeats.contains(seat)) {
                System.out.print(redColor + seat + resetColor + " ");
            } else {
                System.out.print(seat + " ");
            }
        }
	}
	
	public boolean validateSelectedSeats(String[] selectedSeats){
		boolean result = true ;
		for (String seat : selectedSeats) {
            if (!bookedSeats.contains(seat)) {
                result = true ;
            } else {
                result = false ;
				return result ;
            }
        }
		return result ;
	}
	
	public Long getDriverId () {
		String str ="SELECT driver_id FROM busdrivermapping WHERE bus_id = ?;";
		long driverId = -1;
		
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setInt(1,busId);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				driverId = resultSet.getLong("driver_id");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return driverId;
	}
	
	public double getTotalAmount(String[] selectedSeats,int distance){
		double amount = 0.00 ;
		for(int i=0;i<selectedSeats.length;i++){
			String str = """
						SELECT 
							st.seat_type,
							bd.has_ac
						FROM 
							Seats s
						JOIN 
							SeatType st ON s.seat_type = st.id
						JOIN 
							BusSeatGroupMappings bsgm ON s.group_id = bsgm.group_id
						JOIN 
							BusDetails bd ON bsgm.bus_id = bd.id
						WHERE 
							bd.id = ? AND s.seat_number = ?;
							""";
			try{
				Connection connection = DBConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(str);
				statement.setInt(1,busId);
				statement.setString(2,selectedSeats[i]);
				ResultSet resultset = statement.executeQuery();
				
				if(resultset.next()){
					String seatType = resultset.getString("seat_type");
					boolean hasAc = resultset.getBoolean("has_ac");
					
					if(hasAc && seatType.equals("sleeper")){
						amount+= (300+distance+200)*1.5 ;
					}else if(hasAc && seatType.equals("semi-sleeper")){
						amount+= 300+distance+200 ;
					}else if(seatType.equals("sleeper")){
						amount+= (300+distance)*1.5;
					}else{
						amount+= 300+distance;
					}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return amount ;
	}
}
