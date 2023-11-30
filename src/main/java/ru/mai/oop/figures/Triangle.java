package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

public class Triangle extends Figure {

    private final Point[] points;

    public Triangle() {
        this.points = new Point[0];
    }

    public Triangle(Point[] coordinate) {
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
            double firstLine = sqrt(pow((points[0].getX() - points[1].getX()), 2) + pow((points[0].getY() - points[1].getY()), 2)
                    + pow((points[0].getZ() - points[1].getZ()), 2));
            double secondLine = sqrt(pow((points[2].getX() - points[1].getX()), 2) + pow((points[2].getY() - points[1].getY()), 2)
                    + pow((points[2].getZ() - points[1].getZ()), 2));
            double thirdLine = sqrt(pow((points[0].getX() - points[2].getX()), 2) + pow((points[0].getY() - points[2].getY()), 2)
                    + pow((points[0].getZ() - points[2].getZ()), 2));

            if (firstLine + secondLine > thirdLine && firstLine + thirdLine > secondLine && secondLine + thirdLine > firstLine) {
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
        double firstLine = sqrt(pow((points[0].getX() - points[1].getX()), 2) + pow((points[0].getY() - points[1].getY()), 2)
                + pow((points[0].getZ() - points[1].getZ()), 2));
        double secondLine = sqrt(pow((points[2].getX() - points[1].getX()), 2) + pow((points[2].getY() - points[1].getY()), 2)
                + pow((points[2].getZ() - points[1].getZ()), 2));
        double thirdLine = sqrt(pow((points[0].getX() - points[2].getX()), 2) + pow((points[0].getY() - points[2].getY()), 2)
                + pow((points[0].getZ() - points[2].getZ()), 2));
        double halfPerimeter = (firstLine + secondLine + thirdLine) / 2;
        double area = sqrt(halfPerimeter * (halfPerimeter - firstLine) * (halfPerimeter - secondLine) * (halfPerimeter - thirdLine));
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }

    @Override
    public void perimeter() {
        double firstLine = sqrt(pow((points[0].getX() - points[1].getX()), 2) + pow((points[0].getY() - points[1].getY()), 2)
                + pow((points[0].getZ() - points[1].getZ()), 2));
        double secondLine = sqrt(pow((points[2].getX() - points[1].getX()), 2) + pow((points[2].getY() - points[1].getY()), 2)
                + pow((points[2].getZ() - points[1].getZ()), 2));
        double thirdLine = sqrt(pow((points[0].getX() - points[2].getX()), 2) + pow((points[0].getY() - points[2].getY()), 2)
                + pow((points[0].getZ() - points[2].getZ()), 2));
        double perimeter = firstLine + secondLine + thirdLine;
        String result = String.format("%.2f", perimeter).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}
