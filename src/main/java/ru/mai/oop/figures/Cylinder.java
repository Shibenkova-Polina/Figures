package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;

public class Cylinder extends Figure {

    private final Point[] points;
    double radius = 0;

    public Cylinder() {
        this.points = new Point[0];
    }

    public Cylinder(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        int firstPosRadX = points[2].getX() - points[0].getX();
        int firstPosRadY = points[2].getY() - points[0].getY();
        int firstPosRadZ = points[2].getZ() - points[0].getZ();
        double firstPosRad = sqrt(pow(firstPosRadX, 2) + pow(firstPosRadY, 2) + pow(firstPosRadZ, 2));

        int secondPosRadX = points[2].getX() - points[1].getX();
        int secondPosRadY = points[2].getY() - points[1].getY();
        int secondPosRadZ = points[2].getZ() - points[1].getZ();
        double secondPosRad = sqrt(pow(secondPosRadX, 2) + pow(secondPosRadY, 2) + pow(secondPosRadZ, 2));

        int indexRad;

        if (firstPosRad < secondPosRad) {
            radius = firstPosRad;
            indexRad = 1;
        } else {
            radius = secondPosRad;
            indexRad = 2;
        }

        int posHighX = points[1].getX() - points[0].getX();
        int posHighY = points[1].getY() - points[0].getY();
        int posHighZ = points[1].getZ() - points[0].getZ();
        double high = sqrt(pow(posHighX, 2) + pow(posHighY, 2) + pow(posHighZ, 2));

        double vectorMultiplyX;
        double vectorMultiplyY;
        double vectorMultiplyZ;

        if (indexRad == 1) {
            vectorMultiplyX = pow(posHighY * firstPosRadZ - firstPosRadY * posHighZ, 2);
            vectorMultiplyY = pow(-posHighX * firstPosRadZ + firstPosRadX * posHighZ, 2);
            vectorMultiplyZ = pow(posHighX * firstPosRadY - firstPosRadX * posHighY, 2);
        } else {
            vectorMultiplyX = pow(posHighY * secondPosRadZ - secondPosRadY * posHighZ, 2);
            vectorMultiplyY = pow(-posHighX * secondPosRadZ + secondPosRadX * posHighZ, 2);
            vectorMultiplyZ = pow(posHighX * secondPosRadY - secondPosRadX * posHighY, 2);
        }

        double vectorMultiply = sqrt(vectorMultiplyX + vectorMultiplyY + vectorMultiplyZ);
        double posHigh = vectorMultiply / radius;

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
        int firstPosRadX = points[2].getX() - points[0].getX();
        int firstPosRadY = points[2].getY() - points[0].getY();
        int firstPosRadZ = points[2].getZ() - points[0].getZ();
        double firstPosRad = sqrt(pow(firstPosRadX, 2) + pow(firstPosRadY, 2) + pow(firstPosRadZ, 2));

        int secondPosRadX = points[2].getX() - points[1].getX();
        int secondPosRadY = points[2].getY() - points[1].getY();
        int secondPosRadZ = points[2].getZ() - points[1].getZ();
        double secondPosRad = sqrt(pow(secondPosRadX, 2) + pow(secondPosRadY, 2) + pow(secondPosRadZ, 2));

        if (firstPosRad < secondPosRad) {
            radius = firstPosRad;
        } else {
            radius = secondPosRad;
        }
        double high = sqrt(pow(points[1].getX() - points[0].getX(), 2) + pow(points[1].getY() - points[0].getY(), 2)
                + pow(points[1].getZ() - points[0].getZ(), 2));
        double area = 2 * PI * radius * (radius + high);
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }
}
