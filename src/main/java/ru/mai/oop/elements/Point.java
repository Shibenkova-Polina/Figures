package ru.mai.oop.elements;

public class Point {
    private final int getX;
    private final int y;
    private final int z;

    public Point(int coordinateX, int coordinateY) {
        this.getX = coordinateX;
        this.y = coordinateY;
        this.z = 0;
    }

    public Point(int coordinateX, int coordinateY, int coordinateZ) {
        this.getX = coordinateX;
        this.y = coordinateY;
        this.z = coordinateZ;
    }

    public int getX() {
        return getX;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
