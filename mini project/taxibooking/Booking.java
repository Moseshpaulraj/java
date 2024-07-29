import java.util.*;
class Booking
{
    public static void bookTaxi(int customerID,int pickupPoint,int dropPoint,int pickupTime,List<Taxi> freeTaxis)
    {
        int min = 999;
        int tripdistance = 0;
        int earning = 0;
        int nextfreeTime = 0;
        int nextSpot = 10;
        Taxi bookedTaxi = null;
        String tripDetail = "";
     
        for(Taxi taxi : freeTaxis)
        {
            int sourceDistance = (Locations.sourcetime(pickupPoint,taxi.getCurrentSpot())) * 15;
            if(sourceDistance < min)
            {
                bookedTaxi = taxi;
                tripdistance =Locations.tripdistance(pickupPoint,dropPoint);
                earning = tripdistance * 10 + 100;
                int dropTime  = pickupTime + (tripdistance/15); 
                nextfreeTime = dropTime;
                nextSpot = dropPoint;
                tripDetail = customerID + "              " + Locations.route[pickupPoint] +  "      " +Locations.route[dropPoint] + "      " + pickupTime + "               " +dropTime + "          " + earning;
                min = sourceDistance;
            }
        }
		bookedTaxi.setDetails(true,nextSpot,nextfreeTime,bookedTaxi.getTotalEarnings() + earning,tripDetail );
        System.out.println("Taxi " + bookedTaxi.getId() + " booked ! Total  We're all set to pick you up in "+pickupTime +"hrs...Thank you for choosing us for your journey ! ");
    }

    public static List<Taxi> getFreeTaxis(List<Taxi> taxis,int pickupTime,int pickupPoint)
    {
        List<Taxi> freeTaxis = new ArrayList<Taxi>();
        for(Taxi taxi : taxis)
        {   
			int sourcetime = Locations.sourcetime(pickupPoint,taxi.getCurrentSpot());
            if(taxi.getFreeTime()<= pickupTime && sourcetime <= pickupTime - taxi.getFreeTime())
            freeTaxis.add(taxi);
        }
        return freeTaxis;
    } 
}