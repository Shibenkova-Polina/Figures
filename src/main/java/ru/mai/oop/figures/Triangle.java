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
        double firstLine = sqrt(pow((points[0].getX() - points[1].getX()), 2) + pow((points[0].getY() - points[1].getY()), 2)
                + pow((points[0].getZ() - points[1].getZ()), 2));
        double secondLine = sqrt(pow((points[2].getX() - points[1].getX()), 2) + pow((points[2].getY() - points[1].getY()), 2)
                + pow((points[2].getZ() - points[1].getZ()), 2));
        double thirdLine = sqrt(pow((points[0].getX() - points[2].getX()), 2) + pow((points[0].getY() - points[2].getY()), 2)
                + pow((points[0].getZ() - points[2].getZ()), 2));

        if (points[0].getX() == points[1].getX() && points[0].getY() == points[1].getY() && points[0].getZ() == points[1].getZ()
                || points[0].getX() == points[2].getX() && points[0].getY() == points[2].getY() && points[0].getZ() == points[2].getZ()
                || points[2].getX() == points[1].getX() && points[2].getY() == points[1].getY() && points[2].getZ() == points[1].getZ()) {
            System.out.println("The figure is invalid");
        } else if (firstLine + secondLine > thirdLine && firstLine + thirdLine > secondLine && secondLine + thirdLine > firstLine) {
            System.out.println("The figure is valid");
            return true;
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
