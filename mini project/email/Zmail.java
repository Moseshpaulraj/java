import java.util.*;
import java.io.*;
class Zmail{
	static Map<String,User> users = new HashMap<>();
	static String currentUser ;
	
	public static boolean login(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your Zmail id : ");
		String zmail = scanner.next();
		if(users.containsKey(zmail)){
			System.out.println("Enter your Password : ");
			String pw = scanner.next();
			User user = users.get(zmail);
			if((user.getPassword()).equals(pw)){
				System.out.println("Login Successful !!!");
				currentUser = zmail ;
				return true ;
			}else{
				System.out.println("Invalid Password !!!");
				return false ;
			}
		}else{
			System.out.println("Enter Valid Zmail ID !!!");
			return false ;
		}
	}
	
	public static void sendMail(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("From : "+currentUser);
		System.out.println("To : ");
		String tozmail = scanner.next();
		System.out.println("Message : ");
		String dummy = scanner.nextLine();
		String message = scanner.nextLine();

		User sender = users.get(currentUser);
		User receiver = users.get(tozmail);
		if( receiver != null){
			sender.addSentMessage(receiver.getname() + " : " + message);
			receiver.addReceivedMessage(sender.getname() + " : " + message);
			saveUserData();
			System.out.println("Message sent successfully!");
		}else{
			System.out.println("Enter a valid Zmail !!!");
		}	
	}
	
	public static void displayMessages(String messages,String folder){
		System.out.println(folder + " MESSAGES ");
		String[] arr = messages.split(";");
		for(String x : arr){
			System.out.println(x);
		}
	}

	public static void loadUserData(){
		try{
			BufferedReader reader = new BufferedReader(new FileReader(Main.FILENAME));
			String line = reader.readLine();
			while(line!=null){
				String[] userdata = line.split(",");
				User user = new User(userdata[0],userdata[1],userdata[2],userdata[3],userdata[4],userdata[5],userdata[6],userdata[7]);
				users.put(userdata[4],user);
				line = reader.readLine();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void saveUserData(){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(Main.FILENAME));
			for(User user : users.values()){
				writer.write(user.getname()+","+user.getPhone()+","+user.getDob()+","+user.getLocation()+","+user.getZmail()+","+user.getPassword()+"," + user.getSentMessages() + ","+user.getReceivedMessages());
				writer.newLine();
			}
			writer.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
