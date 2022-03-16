package coordinate.figures;

import coordinate.Point;

import java.util.List;

public class Triangle implements Figure {

    private List<Point> points;

    public Triangle(List<Point> points) {
        this.points = points;
    }

    @Override
    public double area() {
        Point point1 = points.get(0);
        Point point2 = points.get(1);
        Point point3 = points.get(2);

        double dist1 = point1.distance(point2);
        double dist2 = point1.distance(point3);
        double dist3 = point2.distance(point3);

        double s =  (dist1 + dist2 + dist3) / 2;
        return Math.sqrt(s * (s - dist1) * (s - dist2) * (s - dist3));
    }
}
