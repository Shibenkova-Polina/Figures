package ru.mai.OOP.figures;

import ru.mai.OOP.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;

public class Cone extends Figure {

    private final Point[] points;

    public Cone() {
        this.points = new Point[0];
    }

    public Cone(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        int posHighX = points[2].x - points[0].x;
        int posHighY = points[2].y - points[0].y;
        int posHighZ = points[2].z - points[0].z;
        double high = sqrt(pow(posHighX, 2) + pow(posHighY, 2) + pow(posHighZ, 2));

        int radX = points[1].x - points[0].x;
        int radY = points[1].y - points[0].y;
        int radZ = points[1].z - points[0].z;
        double radius = sqrt(pow(radX, 2) + pow(radY, 2) + pow(radZ, 2));

        double vectorMultipX = pow(posHighY * radZ - radY * posHighZ, 2);
        double vecrorMultipY = pow(-posHighX * radZ + radX * posHighZ, 2);
        double vectorMultipZ = pow(posHighX * radY - radX * posHighY, 2);
        double vectorMultip = sqrt(vectorMultipX + vecrorMultipY + vectorMultipZ);
        double posHigh = vectorMultip / radius;

        if (posHigh == high) {
            System.out.println("The figure is valid");
            return true;
        } else {
            System.out.println("The figure is invalid");
        }
        return false;
    }

    @Override
    public void area() {
        double radius = sqrt(pow((points[1].x - points[0].x), 2) + pow((points[1].y - points[0].y), 2)
                + pow((points[1].z - points[0].z), 2));
        double high = sqrt(pow((points[2].x - points[0].x), 2) + pow((points[2].y - points[0].y), 2)
                + pow((points[2].z - points[0].z), 2));
        double area = PI * radius * (radius + sqrt(pow(high, 2) + pow(radius, 2)));
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }
}
