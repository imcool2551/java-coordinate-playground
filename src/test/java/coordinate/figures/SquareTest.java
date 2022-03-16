package coordinate.figures;

import coordinate.Point;
import coordinate.factory.FigureFactory;
import coordinate.factory.SquareFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class SquareTest {

    private FigureFactory factory = new SquareFactory();

    @ParameterizedTest
    @MethodSource("providePointsForSquare")
    void 직사각형_생성_성공(List<Point> points) {
        assertDoesNotThrow(() -> {
            factory.create(points);
        });
    }

    @Test
    void 직사각형_생성_실패_좌표_부족() {
        Point point1 = new Point(10, 10);
        Point point2 = new Point(22, 10);
        Point point3 = new Point(22, 18);
        List<Point> points = List.of(point1, point2, point3);

        assertThatThrownBy(() -> {
            factory.getInstance(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 직사각형_생성_실패_직사각형_아님() {
        Point point1 = new Point(10, 10);
        Point point2 = new Point(22, 10);
        Point point3 = new Point(22, 18);
        Point point4 = new Point(0, 18);
        List<Point> points = List.of(point1, point2, point3, point4);

        assertThatThrownBy(() -> {
            factory.getInstance(points);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("providePointsForSquare")
    void 직사각형_면적_계산(List<Point> points) {
        Figure square = factory.getInstance(points);
        assertThat(square.area()).isEqualTo(96);
    }

    private static Stream<List<Point>> providePointsForSquare() {
        Point point1 = new Point(10, 10);
        Point point2 = new Point(22, 10);
        Point point3 = new Point(22, 18);
        Point point4 = new Point(10, 18);
        return Stream.of(List.of(point1, point2, point3, point4));
    }
}
