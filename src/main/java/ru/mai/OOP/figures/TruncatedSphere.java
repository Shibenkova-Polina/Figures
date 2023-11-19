package ru.mai.OOP.figures;

import ru.mai.OOP.elements.Point;

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

    public boolean rightFigure() {
        double fDist = sqrt(pow(points[1].x - points[0].x, 2) + pow(points[1].y - points[0].y, 2) + pow(points[1].z - points[0].z, 2));
        double sDist = sqrt(pow(points[2].x - points[0].x, 2) + pow(points[2].y - points[0].y, 2) + pow(points[2].z - points[0].z, 2));

        if (fDist == sDist) {
            System.out.println("The figure is valid");
            return true;
        } else {
            System.out.println("The figure is invalid");
        }

        return false;
    }

    public void area() {
        double radius = sqrt(pow(points[1].x - points[0].x, 2) + pow(points[1].y - points[0].y, 2) + pow(points[1].z - points[0].z, 2));

        int xCircle = points[0].x;
        int yCircle = points[0].y;

        double rad = sqrt(pow(xCircle - points[2].x, 2) + pow(yCircle - points[2].y, 2));
        double high = radius - sqrt(pow(radius, 2) - pow(rad, 2));
        double area = PI * (radius * 2 * high + pow(rad, 2));
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }
}
