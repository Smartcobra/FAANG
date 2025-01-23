public class Boundary {
    double x, y, width, height;

    public Boundary(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    // Check if a point is within this boundary
    public boolean contains(Point point) {
        return point.x >= x - width && point.x <= x + width &&
                point.y >= y - height && point.y <= y + height;
    }

    // Check if this boundary intersects another boundary
    public boolean intersects(Boundary range) {
        return !(range.x - range.width > x + width ||
                range.x + range.width < x - width ||
                range.y - range.height > y + height ||
                range.y + range.height < y - height);
    }
}
