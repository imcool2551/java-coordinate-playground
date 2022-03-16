package coordinate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PointTest {

    @Test
    void 점_생성() {
        assertDoesNotThrow(() -> {
            new Point(0, 0);
            new Point(24, 24);
        });
    }

    @Test
    void 점_생성_실패() {
        assertThatThrownBy(() -> {
            new Point(-1, -1);
            new Point(25, 25);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
