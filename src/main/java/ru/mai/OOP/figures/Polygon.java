package ru.mai.OOP.figures;

import ru.mai.OOP.elements.Point;

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
            int x1 = points[j].x;
            int y1 = points[j].y;
            int z1 = points[j].z;
            cycle:
            for (int i = j + 1; i < points.length - 1; i++) {
                int x2 = points[i].x;
                int y2 = points[i].y;
                int z2 = points[i].z;
                for (int k = i + 1; k < points.length; k++) {
                    int x3 = points[k].x;
                    int y3 = points[k].y;
                    int z3 = points[k].z;

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
        double zeroX = points[0].x;
        double zeroY = points[0].y;
        double zeroZ = points[0].z;

        for (int i = 1; i < amountPoints; ++i) {
            double fVectorX = points[i].x - zeroX;
            double fVectorY = points[i].y - zeroY;
            double fVectorZ = points[i].z - zeroZ;

            double sVectorX = points[i + 1].x - zeroX;
            double sVectorY = points[i + 1].y - zeroY;
            double sVectorZ = points[i + 1].z - zeroZ;

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
            len += sqrt(pow(points[i].x - points[i + 1].x, 2) + pow(points[i].y - points[i + 1].y, 2) + pow(points[i].z - points[i + 1].z, 2));
        }

        len += sqrt(pow(points[0].x - points[pointsSize].x, 2) + pow(points[0].y - points[pointsSize].y, 2) + pow(points[0].z - points[pointsSize].z, 2));
        String result = String.format("%.2f", len).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}