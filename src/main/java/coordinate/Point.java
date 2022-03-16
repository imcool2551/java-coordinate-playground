package coordinate;

import java.util.Objects;

public class Point {

    private final CoordinateX x;
    private final CoordinateY y;

    public Point(int x, int y) {
        this.x = new CoordinateX(x);
        this.y = new CoordinateY(y);
    }

    public int x() {
        return x.getValue();
    }

    public int y() {
        return y.getValue();
    }

    public double distance(Point point) {
        double xDistance = Math.pow(x() - point.x(), 2);
        double yDistance = Math.pow(y() - point.y(), 2);
        return Math.sqrt(xDistance + yDistance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Objects.equals(x, point.x) && Objects.equals(y, point.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
