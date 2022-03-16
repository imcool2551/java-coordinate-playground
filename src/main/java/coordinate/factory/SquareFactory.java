package coordinate.factory;

import coordinate.Point;
import coordinate.figures.Square;
import coordinate.figures.Figure;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SquareFactory implements FigureFactory {

    @Override
    public Figure create(List<Point> points) {
        return new Square(points);
    }

    @Override
    public void validatePoints(List<Point> points) {
        if (points.size() != 4) {
            throw new IllegalArgumentException("List size must be 4");
        }

        Set<Integer> xCoordinates = new HashSet<>();
        Set<Integer> yCoordinates = new HashSet<>();

        points.stream()
                .forEach(point -> {
                    xCoordinates.add(point.x());
                    yCoordinates.add(point.y());
                });

        if (xCoordinates.size() != 2 || yCoordinates.size() != 2) {
            throw new IllegalArgumentException("Invalid square points");
        }
    }
}
