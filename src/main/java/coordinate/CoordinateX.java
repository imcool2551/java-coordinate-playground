package coordinate;

import java.util.Objects;

public class CoordinateX {

    private final int value;

    public CoordinateX(int value) {
        if (value < 0 || value > 24) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateX that = (CoordinateX) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
