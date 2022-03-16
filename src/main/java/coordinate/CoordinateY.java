package coordinate;

import java.util.Objects;

public class CoordinateY {

    private final int value;

    public CoordinateY(int value) {
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
        CoordinateY that = (CoordinateY) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
