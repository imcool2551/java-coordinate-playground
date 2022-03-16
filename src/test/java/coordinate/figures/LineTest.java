package coordinate.figures;

import coordinate.Point;
import coordinate.factory.FigureFactory;
import coordinate.factory.LineFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    FigureFactory factory = new LineFactory();

    @Test
    void 선_생성_실패_같은_좌표() {
        Point point1 = new Point(10, 10);
        Point point2 = new Point(10, 10);

        assertThatThrownBy(() -> {
            factory.getInstance(List.of(point1, point2));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 선_생성_실패_좌표_2개_미충족() {
        Point point1 = new Point(10, 10);

        assertThatThrownBy(() -> {
            factory.getInstance(List.of(point1));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 선_거리계산() {
        Point point1 = new Point(10, 10);
        Point point2 = new Point(14, 15);

        Figure line = factory.getInstance(List.of(point1, point2));

        assertThat(line.area())
                .isEqualTo(6.403124, offset(0.00099));
    }
}
