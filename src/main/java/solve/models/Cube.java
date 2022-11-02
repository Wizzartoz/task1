package solve.models;

import java.util.Objects;

public class Cube extends Shape {
    private double edge;

    public Cube(double edge) {
        this.edge = edge;
    }

    @Override
    public double getVolume() {
        return Math.pow(edge, 3);
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cube cube = (Cube) o;
        return Double.compare(cube.edge, edge) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), edge);
    }
}
