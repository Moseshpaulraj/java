class Driver{
	private int driverId , taxiId ;
	private String driverName ;
	private String licenceno ;
	private String phoneno ;
	
	
	public Driver(int driverId,String driverName,String licenceno,String phoneno,int taxiId){
		this.driverId=driverId;
		this.driverName=driverName;
		this.licenceno=licenceno;
		this.phoneno=phoneno;
		this.taxiId=taxiId;
	}
	
	public int getDriverId(){
		return driverId ;
	}
	
	public String getDriverName(){
		return driverName ;
	}
	
	public String getLicenceNo(){
		return licenceno ;
	}
	
	public String getPhoneNo(){
		return phoneno ;
	}
	
	public int getTaxiId(){
		return taxiId ;
	}
}