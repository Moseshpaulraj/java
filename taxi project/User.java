import java.sql.*;
class User{
	private int userId ;
	private String userName ;
	private String phoneNo ;
	private String password ;
	private boolean isAdmin ;
	
	public User(String userName,String phoneNo,String password,boolean isAdmin){
		this.userName=userName;
		this.phoneNo=phoneNo;
		this.password=password;
		this.isAdmin=isAdmin;
	}
	
	public int getuserId(){
		return userId ;
	}
	
	public String getUserName(){
		return userName ;
	}
	
	public String getPhoneNo(){
		return phoneNo ;
	}
	
	public String getPassword(){
		return password ;
	}
	
	public boolean getIsAdmin(){
		return isAdmin ;
	}
	
	public void register(){
	String str ="INSERT INTO user_details(name,phone,password,isAdmin) VALUES(?,?,?,false);";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,this.userName);
			statement.setString(2,this.phoneNo);
			statement.setString(3,this.password);
			statement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	static int currentUserId ;
	public static String login(String username , String password){
		String str ="SELECT password,id,isadmin FROM user_details WHERE name = ? ;";
		try{
			Connection connection = DBConnection.getConnection();
			PreparedStatement statement =connection.prepareStatement(str);
			statement.setString(1,username);
			ResultSet resultset=statement.executeQuery();
			if(resultset.next()){
				int userid = resultset.getInt("id");
				String password1 = resultset.getString("password");
				boolean isadmin =  resultset.getBoolean("isadmin");
				if(password.equals(password1) && isadmin == false){
					currentUserId = userid ; 
					return "user" ;
				}else if(password.equals(password1) && isadmin == true){
					currentUserId = userid ; 
					return "admin" ;
				}else{
					System.out.println("incorrect password");
				}
			}else{
				System.out.println("User not found");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "" ;
	}
}