package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.abs;
import static ru.mai.oop.elements.Constants.*;

public class Parallelogram extends Figure {
    private final Point[] points;

    public Parallelogram() {
        this.points = new Point[INDEX_ZERO];
    }

    public Parallelogram(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        boolean check = true;

        cycle:
        for (int j = 0; j < points.length - NUMBER_TWO; j++) {
            int x = points[j].getX();
            int y = points[j].getY();
            int z = points[j].getZ();

            for (int i = j; i < points.length - NUMBER_TWO; i++) {
                int fCalculation = (points[i + NUMBER_ONE].getY() - y) * (points[i + NUMBER_TWO].getZ() - z)
                        - (points[i + NUMBER_TWO].getY() - y) * (points[i + NUMBER_ONE].getZ() - z);
                int sCalculation = -((points[i + NUMBER_ONE].getX() - x) * (points[i + NUMBER_TWO].getZ() - z)
                        - (points[i + NUMBER_TWO].getX() - x) * (points[i + NUMBER_ONE].getZ() - z));
                int tCalculation = (points[i + NUMBER_ONE].getX() - x) * (points[i + NUMBER_TWO].getY() - y)
                        - (points[i + NUMBER_TWO].getX() - x) * (points[i + NUMBER_ONE].getY() - y);
                if (fCalculation + sCalculation + tCalculation == 0) {
                    check = false;
                    break cycle;
                }
            }
        }

        if (check) {
            double firstSide = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_ONE].getX()), SECOND_POWER)
                    + pow((points[INDEX_ZERO].getY() - points[INDEX_ONE].getY()), SECOND_POWER)
                    + pow((points[INDEX_ZERO].getZ() - points[INDEX_ONE].getZ()), SECOND_POWER));
            double secondSide = sqrt(pow((points[INDEX_TWO].getX() - points[INDEX_ONE].getX()), SECOND_POWER)
                    + pow((points[INDEX_TWO].getY() - points[INDEX_ONE].getY()), SECOND_POWER)
                    + pow((points[INDEX_TWO].getZ() - points[INDEX_ONE].getZ()), SECOND_POWER));
            double thirdSide = sqrt(pow((points[INDEX_TWO].getX() - points[INDEX_THREE].getX()), SECOND_POWER)
                    + pow((points[INDEX_TWO].getY() - points[INDEX_THREE].getY()), SECOND_POWER)
                    + pow((points[INDEX_TWO].getZ() - points[INDEX_THREE].getZ()), SECOND_POWER));
            double forthSide = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_THREE].getX()), SECOND_POWER)
                    + pow((points[INDEX_ZERO].getY() - points[INDEX_THREE].getY()), SECOND_POWER)
                    + pow((points[INDEX_ZERO].getZ() - points[INDEX_THREE].getZ()), SECOND_POWER));

            if (firstSide == thirdSide && secondSide == forthSide) {
                System.out.println("The figure is valid");
                return true;
            } else {
                System.out.println("The figure is invalid");
            }
        }  else {
            System.out.println("The figure is invalid");
        }

        return false;
    }

    @Override
    public void area() {
        int firstX = points[INDEX_ZERO].getX() - points[INDEX_ONE].getX();
        int firstY = points[INDEX_ZERO].getY() - points[INDEX_ONE].getY();
        int firstZ = points[INDEX_ZERO].getZ() - points[INDEX_ONE].getZ();
        int secondX = points[INDEX_ZERO].getX() - points[INDEX_THREE].getX();
        int secondY = points[INDEX_ZERO].getY() - points[INDEX_THREE].getY();
        int secondZ = points[INDEX_ZERO].getZ() - points[INDEX_THREE].getZ();

        int vectorX = firstY * secondZ - firstZ * secondY;
        int vectorY = firstZ * secondX - firstX * secondZ;
        int vectorZ = firstX * secondY - firstY * secondX;
        double area = abs(sqrt(pow(vectorX, SECOND_POWER) + pow(vectorY, SECOND_POWER) + pow(vectorZ, SECOND_POWER)));

        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }

    @Override
    public void perimeter() {
        double firstSide = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_ONE].getX()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getY() - points[INDEX_ONE].getY()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getZ() - points[INDEX_ONE].getZ()), SECOND_POWER));
        double secondSide = sqrt(pow((points[INDEX_TWO].getX() - points[INDEX_ONE].getX()), SECOND_POWER)
                + pow((points[INDEX_TWO].getY() - points[INDEX_ONE].getY()), SECOND_POWER)
                + pow((points[INDEX_TWO].getZ() - points[INDEX_ONE].getZ()), SECOND_POWER));
        double perimeter = NUMBER_TWO * (firstSide + secondSide);
        String result = String.format("%.2f", perimeter).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}
