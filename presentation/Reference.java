public class Reference{
    public static void main(String[] args) {
        class Point {
            int x;
            int y;
            Point(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Point p1 = new Point(2, 3);
        Point p2 = p1;
	System.out.println("Point 1: (" + p1.x + ", " + p1.y + ")");
        System.out.println("Point 2: (" + p2.x + ", " + p2.y + ")");  
        p1.x = 5;
        p1.y = 7;
        System.out.println("Point 1: (" + p1.x + ", " + p1.y + ")");
        System.out.println("Point 2: (" + p2.x + ", " + p2.y + ")");
    }
}