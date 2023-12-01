package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import static ru.mai.oop.elements.Constants.*;

public class Square extends Figure {
    private final Point[] points;

    public Square() {
        this.points = new Point[INDEX_ZERO];
    }

    public Square(Point[] coordinate) {
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
            double firstSide = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_ONE].getX()), NUMBER_TWO)
                    + pow((points[INDEX_ZERO].getY() - points[INDEX_ONE].getY()), NUMBER_TWO)
                    + pow((points[INDEX_ZERO].getZ() - points[INDEX_ONE].getZ()), NUMBER_TWO));
            double secondSide = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_THREE].getX()), NUMBER_TWO)
                    + pow((points[INDEX_ZERO].getY() - points[INDEX_THREE].getY()), NUMBER_TWO)
                    + pow((points[INDEX_ZERO].getZ() - points[INDEX_THREE].getZ()), NUMBER_TWO));
            double hypotenuse = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_TWO].getX()), NUMBER_TWO)
                    + pow((points[INDEX_ZERO].getY() - points[INDEX_TWO].getY()), NUMBER_TWO)
                    + pow((points[INDEX_ZERO].getZ() - points[INDEX_TWO].getZ()), NUMBER_TWO));

            if (firstSide == secondSide && hypotenuse == firstSide * sqrt(NUMBER_TWO)) {
                System.out.println("The figure is valid");
                return true;
            } else {
                System.out.println("The figure is invalid");
            }
        } else {
            System.out.println("The figure is invalid");
        }

        return false;
    }

    @Override
    public void area() {
        double side = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_ONE].getX()), NUMBER_TWO)
                + pow((points[INDEX_ZERO].getY() - points[INDEX_ONE].getY()), NUMBER_TWO)
                + pow((points[INDEX_ZERO].getZ() - points[INDEX_ONE].getZ()), NUMBER_TWO));
        double area = pow(side, NUMBER_TWO);
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }

    @Override
    public void perimeter() {
        double side = sqrt(pow((points[INDEX_ZERO].getX() - points[INDEX_ONE].getX()), NUMBER_TWO)
                + pow((points[INDEX_ZERO].getY() - points[INDEX_ONE].getY()), NUMBER_TWO)
                + pow((points[INDEX_ZERO].getZ() - points[INDEX_ONE].getZ()), NUMBER_TWO));
        double perimeter = SIDES_OF_THE_SQUARE * side;
        String result = String.format("%.2f", perimeter).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}
