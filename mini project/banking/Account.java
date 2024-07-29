import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner; 

class Account{
	public static void checkBalance(Connection connection,int account_no){
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your pin : ");
		int pin = scanner.nextInt();
		try{
			String str = "SELECT pin FROM accounts WHERE account_no = ?;";
			PreparedStatement ps = connection.prepareStatement(str);
			ps.setInt(1,account_no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int realPin = rs.getInt("pin");
				if(realPin!=pin){
					System.out.print("INCORRECT PIN");
				}else{
					String str1 = "SELECT balance FROM accounts WHERE account_no = ?;";
					PreparedStatement ps1 = connection.prepareStatement(str1);
					ps1.setInt(1,account_no);
					ResultSet rs1 = ps1.executeQuery();
					if(rs1.next()){
						double balance=rs1.getDouble("balance");
						System.out.println("\nYOUR CURRENT BALANCE : " + balance);
					}
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void closeAccount(Connection connection,int account_no){
		Scanner scanner = new Scanner(System.in);
		try{
		String str = "SELECT balance FROM accounts WHERE account_no = ?;";
		PreparedStatement ps = connection.prepareStatement(str);
		ps.setInt(1,account_no);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			double balance = rs.getDouble("balance");
			if(balance>0){
				System.out.println("WARNING!! : YOU HAVE AMOUNT IN YOUR ACCOUNT , DELETE WHEN BALANCE IS ZERO...");
			}else{
				System.out.print("Enter your pin : ");
				int pin = scanner.nextInt();
				String str1 = "SELECT pin FROM accounts WHERE account_no = ?;";
				PreparedStatement ps1 = connection.prepareStatement(str1);
				ps1.setInt(1,account_no);
				ResultSet rs1 = ps1.executeQuery();
				if(rs1.next()){
					int realPin = rs1.getInt("pin");
					if(realPin!=pin){
						System.out.print("INCORRECT PIN");
					}else{
						String str2 = "DELETE FROM accounts WHERE account_no=?;";
						PreparedStatement ps2 = connection.prepareStatement(str2);
						ps2.setInt(1,account_no);
						int updatedRows = ps2.executeUpdate();
						if (updatedRows > 0) {
							System.out.println("ACCOUNT DELETED SUCCESSFULLY!!");
						} else {
							System.out.println("failed!");
						}
					}
				}
			}
		}
		}
		catch(Exception e){
			//System.out.print("!!!!!!!!!!");
			e.printStackTrace();
		}
	}
}


