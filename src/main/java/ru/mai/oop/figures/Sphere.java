package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;
import static ru.mai.oop.elements.Constants.*;

public class Sphere extends Figure {
    private final Point[] points;

    public Sphere() {
        this.points = new Point[INDEX_ZERO];
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
        double radius = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_ONE].getX()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getY() - points[INDEX_ONE].getY()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getZ() - points[INDEX_ONE].getZ()), SECOND_POWER));
        double area = RATIO_FOR_AREA * PI * pow(radius, SECOND_POWER);
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }
}
