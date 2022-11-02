package solve.models;

import java.util.Objects;

public abstract class Shape implements Comparable<Shape> {
    public abstract double getVolume();

    @Override
    public int compareTo(Shape o) {
        if (getVolume() > o.getVolume()) {
            return 1;
        }
        return (getVolume() < o.getVolume()) ? -1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return shape.getVolume() == this.getVolume();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVolume());
    }
}
