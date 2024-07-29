import java.util.*;
class Taxi
{
    private int id;
    private boolean isBooked; 
    private int currentSpot; 
    private int freeTime; 
    private int totalEarnings; 
    private List<String> trips;
	static int taxicount=1;

    public Taxi()
    {
		id = taxicount++;
        isBooked = false;
        currentSpot = 1;
        freeTime = 0;
        totalEarnings = 0;
        trips = new ArrayList<String>();
    }
	
	public int getId(){
		return id;
	}
	
	public boolean getIsBooked(){
		return isBooked;
	}
	
	public int getCurrentSpot(){
		return currentSpot;
	}

	public int getFreeTime(){
		return freeTime;
	}
	
	public int getTotalEarnings(){
		return totalEarnings;
	}

	public List<String> getTrips(){
		return trips;
	}
	
	public static List<Taxi> createTaxis(int n)
    {
        List<Taxi> taxis = new ArrayList<Taxi>();
        for(int i=1;i<=n;i++)
        {
            Taxi t = new Taxi();
            taxis.add(t);
        }
        return taxis;
    }
    public void setDetails(boolean isBooked,int currentSpot,int freeTime,int totalEarnings,String tripDetail)
    {
            this.isBooked = isBooked;
            this.currentSpot = currentSpot;
            this.freeTime = freeTime;
            this.totalEarnings = totalEarnings;
            this.trips.add(tripDetail);
    }

    public void printTaxiDetails()
    {
        System.out.println("      TAXI - "+ this.id + "\n \nTotal Earnings - " + this.totalEarnings + "\nCurrent spot   - " + Locations.route[this.currentSpot] +"\nFree Time      - " + this.freeTime);
		System.out.println("\n-------------------------------");
    } 	
}