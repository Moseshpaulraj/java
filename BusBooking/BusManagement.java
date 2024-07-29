import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;

class BusManagement {
	
	public void displayBusDetails(){
		String str ="SELECT id,reg_no,has_ac,current_location FROM busdetails WHERE status = 1 ;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()){
				int id = resultset.getInt("id");
				String registerNumber = resultset.getString("reg_no");
				boolean hasAc = resultset.getBoolean("has_ac");
				Short currentLocationId = resultset.getShort("current_location");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Bus getBus(int busId){
		String str ="SELECT reg_no,has_ac,status,current_location FROM busdetails WHERE id = ? AND status =(SELECT id FROM busstatus WHERE status = 'available')";
		Bus bus = null ;
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setInt(1,busId);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()){
				String registerNumber = resultset.getString("reg_no");
				boolean hasAc = resultset.getBoolean("has_ac");
				short statusId = resultset.getShort("status");
				Short currentLocationId = resultset.getShort("current_location");
				bus = new Bus(busId,registerNumber,hasAc,statusId,currentLocationId);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return bus ;
	}

	public void deleteBus(int busId) {
		String str ="UPDATE busdetails SET status = 3 Where id = ?;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setInt(1,busId);
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	} 
	public boolean hasAvailableBus(String pickupLocation,String dropLocation){
		short pickuplocationId =getLocationId(pickupLocation);
		short droplocationId =getLocationId(dropLocation);
		boolean hasAvailableBus = false ;
		String str = """
			SELECT DISTINCT 
				b.id,
				b.reg_no,
				b.has_ac,
				b.current_location, 
				sg.group_name, 
				brm.departure_time, 
				brm.arival_time 
			FROM 
				Route r 
			JOIN 
				RouteMapping rm_pickup ON r.id = rm_pickup.route_id 
			JOIN
				RouteMapping rm_drop ON r.id = rm_drop.route_id 
			JOIN 
				BusRouteMapping brm ON r.id = brm.route_id 
			JOIN 
				BusDetails b ON brm.bus_id = b.id 
			JOIN
				BusSeatGroupMappings bsgm ON b.id = bsgm.bus_id 
			JOIN 
				SeatGroup sg ON bsgm.group_id = sg.id 
			JOIN 
				BusStatus bs ON b.status = bs.id 
			JOIN 
				Locations loc_from ON r.from_id = loc_from.id 
			WHERE 
				(rm_pickup.location_id = ? AND rm_drop.location_id = ? AND rm_pickup.stop_number < rm_drop.stop_number AND bs.status = 'available' AND b.current_location = r.from_id ) 
			OR 
				(rm_pickup.location_id = ? AND rm_drop.location_id = ? AND rm_pickup.stop_number > rm_drop.stop_number AND bs.status = 'available' AND b.current_location = r.to_id)
				""";
			try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setShort(1,pickuplocationId);
			statement.setShort(2,droplocationId);
			statement.setShort(3,pickuplocationId);
			statement.setShort(4,droplocationId);
			ResultSet resultset=statement.executeQuery();
			while(resultset.next()){
				int id = resultset.getInt("id");
				String registerNumber = resultset.getString("reg_no");
				boolean hasAc = resultset.getBoolean("has_ac");
				String seatType = resultset.getString("group_name");
				short currentLocationId = resultset.getShort("current_location");
				Time time = resultset.getTime("departure_time");
				Time arivalTime = resultset.getTime("arival_time");
				LocalTime departureTime = time.toLocalTime();
				LocalTime currentTime = LocalTime.now();
				if(departureTime.isAfter(currentTime)){
					displayAvailableBus(id,registerNumber,hasAc,seatType,departureTime,arivalTime);
				}
				hasAvailableBus = true ;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return hasAvailableBus ;
	}
	public void displayAvailableBus(int busId,String registerNumber,boolean hasAc,String seatType,LocalTime departureTime , Time arivalTime){
		System.out.println("------------------------------------------");
		System.out.print("BUS ID : "+busId);
		System.out.print("  REGISTER NUMBER : "+registerNumber);
		System.out.print("\nSEAT TYPE : "+seatType);
		if(hasAc){
			System.out.println("  A\\C BUS");
		}else{
			System.out.println("  NON A\\C BUS");
		}
		System.out.println("DEPARTURE TIME : " + departureTime);
		System.out.println("ESTIMATED ARIVAL TIME : " + arivalTime);
		System.out.println("------------------------------------------");
	}
	
	public short getLocationId(String location){
		short locationId = -1 ;
		String str = "Select id From locations WHERE name = ? ;" ;
		
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,location);
			ResultSet resultset=statement.executeQuery();
			if(resultset.next()) {
				locationId = resultset.getShort("id");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return locationId ;
	}
	
	public void addNewBus (String reg_no,boolean has_ac,String type,String currentLocation,long driverId,short routeId,LocalTime dep_time,LocalTime arival_time) {
		
		String str = "INSERT INTO busdetails(reg_no,has_ac,status,current_location) Values(?,?,?,(SELECT id  FROM locations WHERE name = ?)) RETURNING id ;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,reg_no);
			statement.setBoolean(2,has_ac);
			statement.setShort(3,(short)1);
			statement.setString(4,currentLocation);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				int	busId = resultSet.getInt("id");
				
				str = "INSERT INTO busseatgroupmappings(bus_id,group_id)VALUES (?,(SELECT id FROM seatgroup WHERE group_name = ?));";
				statement =connection.prepareStatement(str);
				statement.setInt(1,busId);
				statement.setString(2,type);
				statement.executeUpdate();
				
				str = "INSERT INTO busdrivermapping(bus_id,driver_id)VALUES(?,?);";
				statement =connection.prepareStatement(str);
				statement.setInt(1,busId);
				statement.setLong(2,driverId);
				statement.executeUpdate();
				
				str = "INSERT INTO busroutemapping(bus_id,route_id,departure_time,arival_time)VALUES (?,?,?,?);";
				statement =connection.prepareStatement(str);
				statement.setInt(1,busId);
				statement.setShort(2,routeId);
				statement.setObject(3,dep_time);
				statement.setObject(4,arival_time);
				statement.executeUpdate();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}