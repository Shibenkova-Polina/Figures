package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;
import static ru.mai.oop.elements.Constants.*;

public class Cone extends Figure {
    private final Point[] points;

    public Cone() {
        this.points = new Point[INDEX_ZERO];
    }

    public Cone(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        int posHighX = points[INDEX_TWO].getX() - points[INDEX_ZERO].getX();
        int posHighY = points[INDEX_TWO].getY() - points[INDEX_ZERO].getY();
        int posHighZ = points[INDEX_TWO].getZ() - points[INDEX_ZERO].getZ();
        double high = sqrt(pow(posHighX, SECOND_POWER) + pow(posHighY, SECOND_POWER) + pow(posHighZ, SECOND_POWER));

        int radX = points[INDEX_ONE].getX() - points[INDEX_ZERO].getX();
        int radY = points[INDEX_ONE].getY() - points[INDEX_ZERO].getY();
        int radZ = points[INDEX_ONE].getZ() - points[INDEX_ZERO].getZ();
        double radius = sqrt(pow(radX, SECOND_POWER) + pow(radY, SECOND_POWER) + pow(radZ, SECOND_POWER));

        double vectorMultipX = pow(posHighY * radZ - radY * posHighZ, SECOND_POWER);
        double vecrorMultipY = pow(-posHighX * radZ + radX * posHighZ, SECOND_POWER);
        double vectorMultipZ = pow(posHighX * radY - radX * posHighY, SECOND_POWER);
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
        double radius = sqrt(pow((points[INDEX_ONE].getX() - points[INDEX_ZERO].getX()), SECOND_POWER)
                + pow((points[INDEX_ONE].getY() - points[INDEX_ZERO].getY()), SECOND_POWER)
                + pow((points[INDEX_ONE].getZ() - points[INDEX_ZERO].getZ()), SECOND_POWER));
        double high = sqrt(pow((points[INDEX_TWO].getX() - points[INDEX_ZERO].getX()), SECOND_POWER)
                + pow((points[INDEX_TWO].getY() - points[INDEX_ZERO].getY()), SECOND_POWER)
                + pow((points[INDEX_TWO].getZ() - points[INDEX_ZERO].getZ()), SECOND_POWER));
        double area = PI * radius * (radius + sqrt(pow(high, SECOND_POWER) + pow(radius, SECOND_POWER)));
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }
}
