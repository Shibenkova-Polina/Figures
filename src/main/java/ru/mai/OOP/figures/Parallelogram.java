package ru.mai.OOP.figures;

import ru.mai.OOP.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.abs;

public class Parallelogram extends Figure {

    private static final int INDEX_THREE = 3;

    private final Point[] points;

    public Parallelogram() {
        this.points = new Point[0];
    }

    public Parallelogram(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        boolean check = true;

        int x0 = points[0].x;
        int y0 = points[0].y;
        int z0 = points[0].z;

        cycle:
        for (int j = 0; j < points.length - 2; j++) {
            int x = points[j].x;
            int y = points[j].y;
            int z = points[j].z;

            for (int i = j; i < points.length - 2; i++) {
                int fCalculation = (points[i + 1].y - y) * (points[i + 2].z - z) - (points[i + 2].y - y) * (points[i + 1].z - z);
                int sCalculation = -((points[i + 1].x - x) * (points[i + 2].z - z) - (points[i + 2].x - x) * (points[i + 1].z - z));
                int tCalculation = (points[i + 1].x - x) * (points[i + 2].y - y) - (points[i + 2].x - x) * (points[i + 1].y - y);
                if (fCalculation + sCalculation + tCalculation == 0) {
                    check = false;
                    break cycle;
                }
            }
        }

        if (check) {
            double firstSide = sqrt(pow((x0 - points[1].x), 2) + pow((y0 - points[1].y), 2) + pow((z0 - points[1].z), 2));
            double secondSide = sqrt(pow((points[2].x - points[1].x), 2) + pow((points[2].y - points[1].y), 2) + pow((points[2].z - points[1].z), 2));
            double thirdSide = sqrt(pow((points[2].x - points[INDEX_THREE].x), 2) + pow((points[2].y - points[INDEX_THREE].y), 2)
                    + pow((points[2].z - points[INDEX_THREE].z), 2));
            double forthSide = sqrt(pow((x0 - points[INDEX_THREE].x), 2) + pow((y0 - points[INDEX_THREE].y), 2) + pow((z0 - points[INDEX_THREE].z),
                    2));

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
        int firstX = points[0].x - points[1].x;
        int firstY = points[0].y - points[1].y;
        int firstZ = points[0].z - points[1].z;
        int secondX = points[0].x - points[INDEX_THREE].x;
        int secondY = points[0].y - points[INDEX_THREE].y;
        int secondZ = points[0].z - points[INDEX_THREE].z;

        int vectorX = firstY * secondZ - firstZ * secondY;
        int vectorY = firstZ * secondX - firstX * secondZ;
        int vectorZ = firstX * secondY - firstY * secondX;
        double area = abs(sqrt(pow(vectorX, 2) + pow(vectorY, 2) + pow(vectorZ, 2)));

        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }

    @Override
    public void perimeter() {
        double firstSide = sqrt(pow((points[0].x - points[1].x), 2) + pow((points[0].y - points[1].y), 2) + pow((points[0].z - points[1].z), 2));
        double secondSide = sqrt(pow((points[2].x - points[1].x), 2) + pow((points[2].y - points[1].y), 2) + pow((points[2].z - points[1].z), 2));
        double perimeter = 2 * (firstSide + secondSide);
        String result = String.format("%.2f", perimeter).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}
