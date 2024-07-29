import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

class Booking {
    public static void bookTaxi(int customerID, int pickupPoint, int dropPoint, LocalDateTime pickupTime, List<Taxi> freeTaxis) {
        int min = 999;
        int tripdistance = 0;
        int earning = 0;
        LocalDateTime nextfreeTime = LocalDateTime.now();
        int nextSpot = 10;
        Taxi bookedTaxi = null;
        String tripDetail = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        for (Taxi taxi : freeTaxis) {
            int sourceDistance = Locations.sourcetime(pickupPoint, taxi.getCurrentSpot()) * 15;
            if (sourceDistance < min) {
                bookedTaxi = taxi;
                tripdistance = Locations.tripdistance(pickupPoint, dropPoint);
                earning = tripdistance * 10 + 100;
                LocalDateTime dropTime = pickupTime.plusMinutes(tripdistance / 15);
                nextfreeTime = dropTime;
                nextSpot = dropPoint;
                tripDetail = customerID + "              " + Locations.route[pickupPoint] + "      " +
                        Locations.route[dropPoint] + "      " + pickupTime.format(formatter) + "               " +
                        dropTime.format(formatter) + "          " + earning;
                min = sourceDistance;
            }
        }

        bookedTaxi.setDetails(true, nextSpot, nextfreeTime, bookedTaxi.getTotalEarnings() + earning, tripDetail);
        System.out.println("Taxi " + bookedTaxi.getId() + " booked! We'll pick you up at " + pickupTime.format(formatter) + ". Thank you for choosing us!");
    }

    public static List<Taxi> getFreeTaxis(List<Taxi> taxis, LocalDateTime pickupTime, int pickupPoint) {
        List<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi taxi : taxis) {
            int sourceTime = Locations.sourcetime(pickupPoint, taxi.getCurrentSpot()) * 15;
            if (taxi.getFreeTime().isBefore(pickupTime) && 
                ChronoUnit.MINUTES.between(LocalDateTime.now(), pickupTime) >= sourceTime) {
                freeTaxis.add(taxi);
            }
        }
        return freeTaxis;
    }
}
