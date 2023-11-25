package ru.mai.oop.elements;

public class Point {
    private final int x;
    private final int y;
    private final int z;

    public Point(int coordinateX, int coordinateY) {
        this.x = coordinateX;
        this.y = coordinateY;
        this.z = 0;
    }

    public Point(int coordinateX, int coordinateY, int coordinateZ) {
        this.x = coordinateX;
        this.y = coordinateY;
        this.z = coordinateZ;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
