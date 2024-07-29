import java.util.Scanner;
import java.sql.*;
class Banking{
	public static void depositMoney(Connection connection,int account_no){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter deposit Amount : ");
		double amount = scanner.nextDouble();
		try{
		String str = "UPDATE accounts SET balance = balance + ? WHERE account_no = ? ";
		PreparedStatement ps = connection.prepareStatement(str);
		ps.setDouble(1,amount);
		ps.setInt(2,account_no);
		int updatedRows = ps.executeUpdate();
        if (updatedRows > 0) {
        System.out.println("\nAMOUNT DEPOSITED SUCCESSFULLY!");
        } else {
        System.out.println("Account not found!");
        }
		}catch(Exception e){
			System.out.println("ERROR!!");
		}
	}
	public static void withdrawMoney(Connection connection,int account_no){
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter withdraw Amount : ");
		double amount = scanner.nextDouble();
		try{
		String str = "SELECT balance FROM accounts WHERE account_no = ?;";
		PreparedStatement ps = connection.prepareStatement(str);
		ps.setInt(1,account_no);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			double balance = rs.getDouble("balance");
			if(amount>balance){
				System.out.println("\nINSUFICIENT BALANCE");
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
						String str2 = "UPDATE accounts SET balance = balance - ? WHERE account_no=?;";
						PreparedStatement ps2 = connection.prepareStatement(str2);
						ps2.setDouble(1,amount);
						ps2.setInt(2,account_no);
						int updatedRows = ps2.executeUpdate();
						if (updatedRows > 0) {
							System.out.println("\nAMOUNT WITHDRAWED SUCCESSFULLY!!");
						} else {
							System.out.println("withdraw failed!");
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
	public static void transferMoney(Connection connection,int account_no){
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nENTER ACCOUNT_NO TO TRANSFER  : ");
		long acc = scanner.nextLong();
		System.out.print("Enter Amount : ");
		double amount = scanner.nextDouble();
		
		try{
		String str = "SELECT balance FROM accounts WHERE account_no = ?;";
		PreparedStatement ps = connection.prepareStatement(str);
		ps.setInt(1,account_no);
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			double balance = rs.getDouble("balance");
			if(amount>balance){
				System.out.print("INSUFICIENT BALANCE");
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
						String str2 = "UPDATE accounts SET balance = balance - ? WHERE account_no=?;";
						PreparedStatement ps2 = connection.prepareStatement(str2);
						ps2.setDouble(1,amount);
						ps2.setInt(2,account_no);
						int updatedRows = ps2.executeUpdate();
						if (updatedRows > 0) {
							String str3 = "UPDATE accounts SET balance = balance + ? WHERE account_no = ? ";
							PreparedStatement ps3 = connection.prepareStatement(str3);
							ps3.setDouble(1,amount);
							ps3.setLong(2,acc);
							int updatedRows1 = ps3.executeUpdate();
							if (updatedRows1 > 0) {
								System.out.println("\nAMOUNT TRANSFERED SUCCESSFULLY!");
							} else {
							System.out.println("Account not found!");
							}
						} else {
						System.out.println("withdraw failed!");
						}
					}
				}
			}
		}
		}
		catch(Exception e){
		e.printStackTrace();
	}
	}
}