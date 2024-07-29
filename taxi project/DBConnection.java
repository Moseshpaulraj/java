import java.sql.*;
public class DBConnection{
	public static Connection getConnection() throws Exception{
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/taxi_booking","moses","54321"); 
		return connection;	
	}
}