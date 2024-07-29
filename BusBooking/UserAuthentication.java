import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

class UserAuthentication {
	
	public void signup(String name,String phoneNumber,String password){
		String str ="INSERT INTO users(name,phone_number,type_id,status_id) VALUES(?,?,(SELECT id FROM usertype WHERE type = ?),(SELECT id FROM userstatus WHERE status = ?))RETURNING id;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,name);
			statement.setString(2,phoneNumber);
			statement.setString(3,"customer");
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
			System.out.println("Mobile Number Already Have Account ");
		}
	}
	
	public boolean signIn(String phoneNumber,String password){
		String str ="""
					SELECT 
						u.id,u.name,u.type_id,u.status_id
					FROM 
						users u 
					JOIN 
						UserPasswordMapping upm ON u.id =upm.user_id 
					WHERE 
						u.phone_number =? 
					AND 
						upm.password =? 
					AND 
						u.status_id =(SELECT id FROM userstatus WHERE status = ? );
					""";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(str);
			statement.setString(1,phoneNumber);
			statement.setString(2,password);
			statement.setString(3,"ACTIVE");
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()){
				long userId = resultSet.getLong("id");
				String name = resultSet.getString("name");
				short typeId = resultSet.getShort("type_id");
				short statusId = resultSet.getShort("status_id");
				User user = new User(userId,name,phoneNumber,typeId,statusId);
				UserContext.setUser(user);
				return true ;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}