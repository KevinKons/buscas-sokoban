package model;

import java.util.Objects;

public class Coordenada {

    private int y;
    private int x;

    public Coordenada(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Coordenada that = (Coordenada) o;
        return y == that.y &&
                x == that.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }

    @Override
    public String toString() {
        return "Coordenada{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Coordenada clonar() {
        return new Coordenada(y, x);
    }
}
