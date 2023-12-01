package ru.mai.oop.figures;

import ru.mai.oop.elements.Point;

import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;
import static ru.mai.oop.elements.Constants.*;

public class TruncatedSphere extends Figure {
    private final Point[] points;

    public TruncatedSphere() {
        this.points = new Point[INDEX_ZERO];
    }

    public TruncatedSphere(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        double fDist = sqrt(pow(points[INDEX_ONE].getX() - points[INDEX_ZERO].getX(), SECOND_POWER)
                + pow(points[INDEX_ONE].getY() - points[INDEX_ZERO].getY(), SECOND_POWER)
                + pow(points[INDEX_ONE].getZ() - points[INDEX_ZERO].getZ(), SECOND_POWER));
        double sDist = sqrt(pow(points[INDEX_TWO].getX() - points[INDEX_ZERO].getX(), SECOND_POWER)
                + pow(points[INDEX_TWO].getY() - points[INDEX_ZERO].getY(), SECOND_POWER)
                + pow(points[INDEX_TWO].getZ() - points[INDEX_ZERO].getZ(), SECOND_POWER));

        if (fDist == sDist) {
            System.out.println("The figure is valid");
            return true;
        } else {
            System.out.println("The figure is invalid");
        }

        return false;
    }

    @Override
    public void area() {
        double radius = sqrt(pow(points[INDEX_ONE].getX() - points[INDEX_ZERO].getX(), SECOND_POWER)
                + pow(points[INDEX_ONE].getY() - points[INDEX_ZERO].getY(), SECOND_POWER)
                + pow(points[INDEX_ONE].getZ() - points[INDEX_ZERO].getZ(), SECOND_POWER));
        int xCircle = points[INDEX_ZERO].getX();
        int yCircle = points[INDEX_ZERO].getY();

        double rad = sqrt(pow(xCircle - points[INDEX_TWO].getX(), SECOND_POWER) + pow(yCircle - points[INDEX_TWO].getY(), SECOND_POWER));
        double high = radius - sqrt(pow(radius, SECOND_POWER) - pow(rad, SECOND_POWER));
        double area = PI * (radius * NUMBER_TWO * high + pow(rad, SECOND_POWER));
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }
}
