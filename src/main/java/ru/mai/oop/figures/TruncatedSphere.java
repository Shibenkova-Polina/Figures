package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;

public class TruncatedSphere extends Figure {

    private final Point[] points;

    public TruncatedSphere() {
        this.points = new Point[0];
    }

    public TruncatedSphere(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        double fDist = sqrt(pow(points[1].getX() - points[0].getX(), 2) + pow(points[1].getY() - points[0].getY(), 2)
                + pow(points[1].getZ() - points[0].getZ(), 2));
        double sDist = sqrt(pow(points[2].getX() - points[0].getX(), 2) + pow(points[2].getY() - points[0].getY(), 2)
                + pow(points[2].getZ() - points[0].getZ(), 2));

        if (fDist == sDist) {
            System.out.println("The figure is valid");
            return true;
        } else {
            System.out.println("The figure is invalid");
        }

        return false;
    }

    @Override
    public void area() {
        double radius = sqrt(pow(points[1].getX() - points[0].getX(), 2) + pow(points[1].getY() - points[0].getY(), 2)
                + pow(points[1].getZ() - points[0].getZ(), 2));
        int xCircle = points[0].getX();
        int yCircle = points[0].getY();

        double rad = sqrt(pow(xCircle - points[2].getX(), 2) + pow(yCircle - points[2].getY(), 2));
        double high = radius - sqrt(pow(radius, 2) - pow(rad, 2));
        double area = PI * (radius * 2 * high + pow(rad, 2));
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }
}
