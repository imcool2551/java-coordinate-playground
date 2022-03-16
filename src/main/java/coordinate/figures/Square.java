package coordinate.figures;

import coordinate.Point;

import java.util.List;
import java.util.stream.Collectors;

public class Square implements Figure {

    private final List<Point> points;

    public Square(List<Point> points) {
        this.points = points;
    }

    @Override
    public double area() {
        Point point = points.get(0);

        List<Double> distances = points.stream()
                .mapToDouble(p -> p.distance(point))
                .filter(distance -> distance > 0)
                .sorted()
                .limit(2)
                .boxed()
                .collect(Collectors.toList());

        return distances.get(0) * distances.get(1);
    }

}
