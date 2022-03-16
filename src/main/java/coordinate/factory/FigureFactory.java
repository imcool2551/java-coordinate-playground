package coordinate.factory;

import coordinate.Point;
import coordinate.figures.Figure;

import java.util.List;

public interface FigureFactory {

    default Figure getInstance(List<Point> points) {
        validatePoints(points);
        return create(points);
    }

    Figure create(List<Point> points);

    void validatePoints(List<Point> points);
}
