import java.util.ArrayList;
import java.util.List;

public class QuadTree {
    private static final int CAPACITY = 4; // Maximum points per node
    private Boundary boundary;
    private List<Point> points;
    private boolean divided;
    private QuadTree northeast, northwest, southeast, southwest;

    public QuadTree(Boundary boundary) {
        this.boundary = boundary;
        this.points = new ArrayList<>();
        this.divided = false;
    }

    // Subdivide this node into four quadrants
    private void subdivide() {
        double x = boundary.x;
        double y = boundary.y;
        double halfWidth = boundary.width / 2;
        double halfHeight = boundary.height / 2;

        northeast = new QuadTree(new Boundary(x + halfWidth, y - halfHeight, halfWidth, halfHeight));
        northwest = new QuadTree(new Boundary(x - halfWidth, y - halfHeight, halfWidth, halfHeight));
        southeast = new QuadTree(new Boundary(x + halfWidth, y + halfHeight, halfWidth, halfHeight));
        southwest = new QuadTree(new Boundary(x - halfWidth, y + halfHeight, halfWidth, halfHeight));

        divided = true;
    }

    // Insert a point into the quadtree
    public boolean insert(Point point) {
        if (!boundary.contains(point)) {
            return false; // Point is outside the boundary
        }

        if (points.size() < CAPACITY) {
            points.add(point);
            return true;
        } else {
            if (!divided) {
                subdivide();
            }

            if (northeast.insert(point)) return true;
            if (northwest.insert(point)) return true;
            if (southeast.insert(point)) return true;
            if (southwest.insert(point)) return true;
        }

        return false;
    }

    // Query points within a range
    public List<Point> query(Boundary range, List<Point> found) {
        if (!boundary.intersects(range)) {
            return found; // No intersection
        }

        for (Point point : points) {
            if (range.contains(point)) {
                found.add(point);
            }
        }

        if (divided) {
            northeast.query(range, found);
            northwest.query(range, found);
            southeast.query(range, found);
            southwest.query(range, found);
        }

        return found;
    }
}
