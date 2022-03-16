package coordinate.factory;

import coordinate.Point;
import coordinate.figures.Triangle;
import coordinate.figures.Figure;

import java.util.List;

public class TriangleFactory implements FigureFactory {

    @Override
    public Figure create(List<Point> points) {
        return new Triangle(points);
    }

    @Override
    public void validatePoints(List<Point> points) {
        if (points.size() != 3) {
            throw new IllegalArgumentException("List size must be 3");
        }

        Point point = points.get(0);

        long count = points.stream()
                .filter(point::equals)
                .count();

        if (count > 1) {
            throw new IllegalArgumentException("Triangle can not have same points");
        }
    }
}
