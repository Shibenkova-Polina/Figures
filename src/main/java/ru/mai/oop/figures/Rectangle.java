package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static ru.mai.oop.elements.Constants.*;

public class Rectangle extends Figure {
    private final Point[] points;

    public Rectangle() {
        this.points = new Point[INDEX_ZERO];
    }

    public Rectangle(Point[] coordinate) {
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
                        - (points[i + NUMBER_TWO].getX() - x) * (points[i + NUMBER_ONE].getX() - y);
                if (fCalculation + sCalculation + tCalculation == 0) {
                    check = false;
                    break cycle;
                }
            }
        }

        if (check) {
            double firstDiagonal = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_TWO].getX()), SECOND_POWER)
                    + pow((points[INDEX_ZERO].getY() - points[INDEX_TWO].getY()), SECOND_POWER)
                    + pow((points[INDEX_ZERO].getZ() - points[INDEX_TWO].getZ()), SECOND_POWER));
            double secondDiagonal = sqrt(pow((points[INDEX_ONE].getX() - points[INDEX_THREE].getX()), SECOND_POWER)
                    + pow((points[INDEX_ONE].getY() - points[INDEX_THREE].getY()), SECOND_POWER)
                    + pow((points[INDEX_ONE].getZ() - points[INDEX_THREE].getZ()), SECOND_POWER));

            if (firstDiagonal == secondDiagonal) {
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
        double firstSide = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_ONE].getX()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getY() - points[INDEX_ONE].getY()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getZ() - points[INDEX_ONE].getZ()), SECOND_POWER));
        double secondSide = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_THREE].getX()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getY() - points[INDEX_THREE].getY()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getZ() - points[INDEX_THREE].getZ()), SECOND_POWER));
        double area = firstSide * secondSide;
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }

    @Override
    public void perimeter() {
        double firstSide = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_ONE].getX()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getY() - points[INDEX_ONE].getY()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getZ() - points[INDEX_ONE].getZ()), SECOND_POWER));
        double secondSide = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_THREE].getX()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getY() - points[INDEX_THREE].getY()), SECOND_POWER)
                + pow((points[INDEX_ZERO].getZ() - points[INDEX_THREE].getZ()), SECOND_POWER));
        double perimeter = NUMBER_TWO * (firstSide + secondSide);
        String result = String.format("%.2f", perimeter).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}
