package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import java.util.zip.ZipEntry;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;
import static ru.mai.oop.elements.Constants.*;

public class Cylinder extends Figure {
    private final Point[] points;
    double radius = 0;

    public Cylinder() {
        this.points = new Point[INDEX_ZERO];
    }

    public Cylinder(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        int firstPosRadX = points[INDEX_TWO].getX() - points[INDEX_ZERO].getX();
        int firstPosRadY = points[INDEX_TWO].getY() - points[INDEX_ZERO].getY();
        int firstPosRadZ = points[INDEX_TWO].getZ() - points[INDEX_ZERO].getZ();
        double firstPosRad = sqrt(pow(firstPosRadX, SECOND_POWER) + pow(firstPosRadY, SECOND_POWER) + pow(firstPosRadZ, SECOND_POWER));

        int secondPosRadX = points[INDEX_TWO].getX() - points[INDEX_ONE].getX();
        int secondPosRadY = points[INDEX_TWO].getY() - points[INDEX_ONE].getY();
        int secondPosRadZ = points[INDEX_TWO].getZ() - points[INDEX_ONE].getZ();
        double secondPosRad = sqrt(pow(secondPosRadX, SECOND_POWER) + pow(secondPosRadY, SECOND_POWER) + pow(secondPosRadZ, SECOND_POWER));

        int indexRad;

        if (firstPosRad < secondPosRad) {
            radius = firstPosRad;
            indexRad = NUMBER_ONE;
        } else {
            radius = secondPosRad;
            indexRad = NUMBER_TWO;
        }

        int posHighX = points[INDEX_ONE].getX() - points[INDEX_ZERO].getX();
        int posHighY = points[INDEX_ONE].getY() - points[INDEX_ZERO].getY();
        int posHighZ = points[INDEX_ONE].getZ() - points[INDEX_ZERO].getZ();
        double high = sqrt(pow(posHighX, SECOND_POWER) + pow(posHighY, SECOND_POWER) + pow(posHighZ, SECOND_POWER));

        double vectorMultiplyX;
        double vectorMultiplyY;
        double vectorMultiplyZ;

        if (indexRad == NUMBER_ONE) {
            vectorMultiplyX = pow(posHighY * firstPosRadZ - firstPosRadY * posHighZ, SECOND_POWER);
            vectorMultiplyY = pow(-posHighX * firstPosRadZ + firstPosRadX * posHighZ, SECOND_POWER);
            vectorMultiplyZ = pow(posHighX * firstPosRadY - firstPosRadX * posHighY, SECOND_POWER);
        } else {
            vectorMultiplyX = pow(posHighY * secondPosRadZ - secondPosRadY * posHighZ, SECOND_POWER);
            vectorMultiplyY = pow(-posHighX * secondPosRadZ + secondPosRadX * posHighZ, SECOND_POWER);
            vectorMultiplyZ = pow(posHighX * secondPosRadY - secondPosRadX * posHighY, SECOND_POWER);
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
        int firstPosRadX = points[INDEX_TWO].getX() - points[INDEX_ZERO].getX();
        int firstPosRadY = points[INDEX_TWO].getY() - points[INDEX_ZERO].getY();
        int firstPosRadZ = points[INDEX_TWO].getZ() - points[INDEX_ZERO].getZ();
        double firstPosRad = sqrt(pow(firstPosRadX, SECOND_POWER) + pow(firstPosRadY, SECOND_POWER) + pow(firstPosRadZ, SECOND_POWER));

        int secondPosRadX = points[INDEX_TWO].getX() - points[INDEX_ONE].getX();
        int secondPosRadY = points[INDEX_TWO].getY() - points[INDEX_ONE].getY();
        int secondPosRadZ = points[INDEX_TWO].getZ() - points[INDEX_ONE].getZ();
        double secondPosRad = sqrt(pow(secondPosRadX, SECOND_POWER) + pow(secondPosRadY, SECOND_POWER) + pow(secondPosRadZ, SECOND_POWER));

        if (firstPosRad < secondPosRad) {
            radius = firstPosRad;
        } else {
            radius = secondPosRad;
        }
        double high = sqrt(pow(points[INDEX_ONE].getX() - points[INDEX_ZERO].getX(), SECOND_POWER)
                + pow(points[INDEX_ONE].getY() - points[INDEX_ZERO].getY(), SECOND_POWER)
                + pow(points[INDEX_ONE].getZ() - points[INDEX_ZERO].getZ(), SECOND_POWER));
        double area = NUMBER_TWO * PI * radius * (radius + high);
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }
}
