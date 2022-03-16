package coordinate.factory;

import coordinate.figures.Line;
import coordinate.Point;
import coordinate.figures.Figure;

import java.util.List;

public class LineFactory implements FigureFactory {

    @Override
    public Figure create(List<Point> points) {
        return new Line(points);
    }

    @Override
    public void validatePoints(List<Point> points) {
        if (points.size() != 2) {
            throw new IllegalArgumentException("line must have 2 points");
        }

        if (points.get(0).equals(points.get(1))) {
            throw new IllegalArgumentException("line must have 2 different points");
        }
    }
}
