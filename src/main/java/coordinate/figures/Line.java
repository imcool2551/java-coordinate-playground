package coordinate.figures;

import coordinate.Point;

import java.util.List;

public class Line implements Figure {

    private List<Point> points;

    public Line(List<Point> points) {
        this.points = points;
    }

    @Override
    public double area() {
        Point point1 = points.get(0);
        Point point2 = points.get(1);

        return point1.distance(point2);
    }

}
