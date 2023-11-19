package ru.mai.OOP.elements;

public class Point {
    public final int x;
    public final int y;
    public final int z;

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
}
