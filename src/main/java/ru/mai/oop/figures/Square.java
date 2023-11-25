package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Square extends Figure {

    private static final int INDEX_THREE = 3;
    private static final int SIDES_OF_THE_SQUARE = 4;

    private final Point[] points;

    public Square() {
        this.points = new Point[0];
    }

    public Square(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        boolean check = true;

        int x0 = points[0].getX();
        int y0 = points[0].getY();
        int z0 = points[0].getZ();

        cycle:
        for (int j = 0; j < points.length - 2; j++) {
            int x = points[j].getX();
            int y = points[j].getY();
            int z = points[j].getZ();

            for (int i = j; i < points.length - 2; i++) {
                int fCalculation = (points[i + 1].getY() - y) * (points[i + 2].getZ() - z) - (points[i + 2].getY() - y) * (points[i + 1].getZ() - z);
                int sCalculation = -((points[i + 1].getX() - x) * (points[i + 2].getZ() - z)
                        - (points[i + 2].getX() - x) * (points[i + 1].getZ() - z));
                int tCalculation = (points[i + 1].getX() - x) * (points[i + 2].getY() - y) - (points[i + 2].getX() - x) * (points[i + 1].getY() - y);
                if (fCalculation + sCalculation + tCalculation == 0) {
                    check = false;
                    break cycle;
                }
            }
        }

        if (check) {
            double firstSide = sqrt(pow((x0 - points[1].getX()), 2) + pow((y0 - points[1].getY()), 2) + pow((z0 - points[1].getZ()), 2));
            double secondSide = sqrt(pow((x0 - points[INDEX_THREE].getX()), 2) + pow((y0 - points[INDEX_THREE].getY()), 2)
                    + pow((z0 - points[INDEX_THREE].getZ()), 2));
            double hypotenuse = sqrt(pow((x0 - points[2].getX()), 2) + pow((y0 - points[2].getY()), 2) + pow((z0 - points[2].getZ()), 2));

            if (firstSide == secondSide && hypotenuse == firstSide * sqrt(2)) {
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
        double side = sqrt(pow((points[0].getX() - points[1].getX()), 2) + pow((points[0].getY() - points[1].getY()), 2)
                + pow((points[0].getZ() - points[1].getZ()), 2));
        double area = pow(side, 2);
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }

    @Override
    public void perimeter() {
        double side = sqrt(pow((points[0].getX() - points[1].getX()), 2) + pow((points[0].getY() - points[1].getY()), 2)
                + pow((points[0].getZ() - points[1].getZ()), 2));
        double perimeter = SIDES_OF_THE_SQUARE * side;
        String result = String.format("%.2f", perimeter).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}
