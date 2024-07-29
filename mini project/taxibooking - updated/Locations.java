class Locations {
    static String[] route = {"kanniyakumari", "tirunelveli", "madurai", "salem", "chennai"};

    public static void routes() {
        System.out.println("------------------------------");
        for (int i = 0; i < route.length; i++) {
            System.out.println("         " + (i + 1) + "->" + route[i]);
        }
        System.out.println("------------------------------");
    }

    public static int sourcetime(int pickupPoint, int currentSpot) {
        return Math.abs(pickupPoint - currentSpot);
    }

    public static int tripdistance(int pickupPoint, int dropPoint) {
        return Math.abs(dropPoint - pickupPoint) * 15;
    }
}
