package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Polygon extends Figure {

    private final Point[] points;

    public Polygon() {
        this.points = new Point[0];
    }

    public Polygon(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        boolean check = true;

        for (int j = 0; j < points.length - 2; j++) {
            int x1 = points[j].getX();
            int y1 = points[j].getY();
            int z1 = points[j].getZ();
            cycle:
            for (int i = j + 1; i < points.length - 1; i++) {
                int x2 = points[i].getX();
                int y2 = points[i].getY();
                int z2 = points[i].getZ();
                for (int k = i + 1; k < points.length; k++) {
                    int x3 = points[k].getX();
                    int y3 = points[k].getY();
                    int z3 = points[k].getZ();

                    int fCalculation = (y2 - y1) * (z3 - z2) - (z2 - z1) * (y3 - y2);
                    int sCalculation = -((x2 - x1) * (z3 - z2) - (z2 - z1) * (x3 - x2));
                    int tCalculation = (x2 - x1) * (y3 - y2) - (y2 - y1) * (x3 - x2);
                    if (fCalculation + sCalculation + tCalculation == 0) {
                        check = false;
                        break cycle;
                    }
                }
            }
        }

        if (check) {
            System.out.println("The figure is valid");
            return true;
        }  else {
            System.out.println("The figure is invalid");
        }

        return false;
    }

    @Override
    public void area() {
        double summa = 0;
        int amountPoints = points.length - 1;
        double zeroX = points[0].getX();
        double zeroY = points[0].getY();
        double zeroZ = points[0].getZ();

        for (int i = 1; i < amountPoints; ++i) {
            double fVectorX = points[i].getX() - zeroX;
            double fVectorY = points[i].getY() - zeroY;
            double fVectorZ = points[i].getZ() - zeroZ;

            double sVectorX = points[i + 1].getX() - zeroX;
            double sVectorY = points[i + 1].getY() - zeroY;
            double sVectorZ = points[i + 1].getZ() - zeroZ;

            double fCalc = fVectorY * sVectorZ - fVectorZ * sVectorY;
            double sCalc = fVectorX * sVectorZ - fVectorZ * sVectorZ;
            double tCalc = fVectorX * sVectorY - fVectorY * sVectorX;
            summa += fCalc - sCalc + tCalc;
        }

        double area = Math.abs(summa) / 2;
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }

    @Override
    public void perimeter() {
        double len = 0;
        int pointsSize = points.length - 1;

        for (int i = 0; i < pointsSize; i++) {
            len += sqrt(pow(points[i].getX() - points[i + 1].getX(), 2) + pow(points[i].getY() - points[i + 1].getY(), 2)
                    + pow(points[i].getZ() - points[i + 1].getZ(), 2));
        }

        len += sqrt(pow(points[0].getX() - points[pointsSize].getX(), 2) + pow(points[0].getY() - points[pointsSize].getY(), 2)
                + pow(points[0].getZ() - points[pointsSize].getZ(), 2));
        String result = String.format("%.2f", len).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}