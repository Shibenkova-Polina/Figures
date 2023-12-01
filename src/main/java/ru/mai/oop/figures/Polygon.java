package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static ru.mai.oop.elements.Constants.*;

public class Polygon extends Figure {
    private final Point[] points;

    public Polygon() {
        this.points = new Point[INDEX_ZERO];
    }

    public Polygon(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        boolean check = true;

        for (int j = 0; j < points.length - NUMBER_TWO; j++) {
            int xFirst = points[j].getX();
            int yFirst = points[j].getY();
            int zFirst = points[j].getZ();

            cycle:
            for (int i = j + NUMBER_ONE; i < points.length - NUMBER_ONE; i++) {
                int xSecond = points[i].getX();
                int ySecond = points[i].getY();
                int zSecond = points[i].getZ();

                for (int k = i + NUMBER_ONE; k < points.length; k++) {
                    int xThird = points[k].getX();
                    int yThird = points[k].getY();
                    int zThird = points[k].getZ();

                    int fCalculation = (ySecond - yFirst) * (zThird - zSecond) - (zSecond - zFirst) * (yThird - ySecond);
                    int sCalculation = -((xSecond - xFirst) * (zThird - zSecond) - (zSecond - zFirst) * (xThird - xSecond));
                    int tCalculation = (xSecond - xFirst) * (yThird - ySecond) - (ySecond - yFirst) * (xThird - xSecond);
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
        int amountPoints = points.length - NUMBER_ONE;
        double zeroX = points[INDEX_ZERO].getX();
        double zeroY = points[INDEX_ZERO].getY();
        double zeroZ = points[INDEX_ZERO].getZ();

        for (int i = NUMBER_ONE; i < amountPoints; ++i) {
            double fVectorX = points[i].getX() - zeroX;
            double fVectorY = points[i].getY() - zeroY;
            double fVectorZ = points[i].getZ() - zeroZ;

            double sVectorX = points[i + NUMBER_ONE].getX() - zeroX;
            double sVectorY = points[i + NUMBER_ONE].getY() - zeroY;
            double sVectorZ = points[i + NUMBER_ONE].getZ() - zeroZ;

            double fCalc = fVectorY * sVectorZ - fVectorZ * sVectorY;
            double sCalc = fVectorX * sVectorZ - fVectorZ * sVectorZ;
            double tCalc = fVectorX * sVectorY - fVectorY * sVectorX;
            summa += fCalc - sCalc + tCalc;
        }

        double area = Math.abs(summa) / NUMBER_TWO;
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }

    @Override
    public void perimeter() {
        double len = 0;
        int pointsSize = points.length - NUMBER_ONE;

        for (int i = 0; i < pointsSize; i++) {
            len += sqrt(pow(points[i].getX() - points[i + NUMBER_ONE].getX(), SECOND_POWER)
                    + pow(points[i].getY() - points[i + NUMBER_ONE].getY(), SECOND_POWER)
                    + pow(points[i].getZ() - points[i + NUMBER_ONE].getZ(), SECOND_POWER));
        }

        len += sqrt(pow(points[INDEX_ZERO].getX() - points[pointsSize].getX(), SECOND_POWER)
                + pow(points[INDEX_ZERO].getY() - points[pointsSize].getY(), SECOND_POWER)
                + pow(points[INDEX_ZERO].getZ() - points[pointsSize].getZ(), SECOND_POWER));
        String result = String.format("%.2f", len).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}