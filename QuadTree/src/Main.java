import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boundary geofence = new Boundary(0, 0, 10, 10);
        QuadTree quadTree = new QuadTree(geofence);

        // Insert vehicle positions into the quadtree
        quadTree.insert(new Point(2, 3)); // Vehicle inside the geofence
        quadTree.insert(new Point(12, 8)); // Vehicle outside the geofence

        // Define a range for querying (the geofence)
        Boundary queryRange = new Boundary(0, 0, 10, 10);

        // Query points (vehicles) within the geofence
        List<Point> found = quadTree.query(queryRange, new ArrayList<>());

        System.out.println("Vehicles inside geofence: " + found.size());

        // Check if a specific vehicle is outside the geofence
        Point testVehicle = new Point(12, 8);
        if (!geofence.contains(testVehicle)) {
            System.out.println("Theft Alert! Vehicle is outside the geofence.");
        }
    }


}