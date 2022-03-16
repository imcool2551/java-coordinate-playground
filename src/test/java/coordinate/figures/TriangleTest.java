package coordinate.figures;

import coordinate.Point;
import coordinate.factory.FigureFactory;
import coordinate.factory.TriangleFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class TriangleTest {

    private FigureFactory factory = new TriangleFactory();

    @Test
    void 삼각형_생성_실패_좌표_부족() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(10, 10));
        points.add(new Point(14, 15));

        assertThatThrownBy(() -> {
            factory.getInstance(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 삼각형_생성_실패_같은_좌표() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(10, 10));
        points.add(new Point(10, 10));
        points.add(new Point(20, 8));

        assertThatThrownBy(() -> {
            factory.getInstance(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 삼각형_면적() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(10, 10));
        points.add(new Point(14, 15));
        points.add(new Point(20, 8));

        Figure triangle = factory.getInstance(points);

        assertThat(triangle.area()).isEqualTo(29.0, offset(0.00099));
    }

}
