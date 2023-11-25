package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;

public class Sphere extends Figure {

    private static final int RATIO_FOR_AREA = 4;

    private final Point[] points;

    public Sphere() {
        this.points = new Point[0];
    }

    public Sphere(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        System.out.println("The figure is valid");
        return true;
    }

    @Override
    public void area() {
        double radius = sqrt(pow((points[0].getX() - points[1].getX()), 2) + pow((points[0].getY() - points[1].getY()), 2)
                + pow((points[0].getZ() - points[1].getZ()), 2));
        double area = RATIO_FOR_AREA * PI * pow(radius, 2);
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }
}
