class User{
	
	private String name,phone,dob,location,zmail,password,sentMessages,receivedMessages;
	
	User(String name,String phone,String dob,String location,String zmail,String password,String sentMessages,String receivedMessages){
		this.name = name;
		this.phone = phone;
		this.dob = dob;
		this.location = location;
		this.zmail = zmail;
		this.password = password;
		this.sentMessages = sentMessages;
		this.receivedMessages = receivedMessages;
	}
	
	public String getname(){
		return name ;
	}
	
	public String getPhone(){
		return phone ;
	}
	
	public String getDob(){
		return dob ;
	}
	
	public String getLocation(){
		return location ;
	}
	
	public String getZmail(){
		return zmail ;
	}
	
	public String getPassword(){
		return password ;
	}
	
	public String getSentMessages(){
		return sentMessages ;
	}
	
	public String getReceivedMessages(){
		return receivedMessages ;
	}
	
	public void addSentMessage(String message){
		sentMessages = sentMessages + message ;
	}

	public void addReceivedMessage(String message){
		receivedMessages = receivedMessages + message ;
	}

}