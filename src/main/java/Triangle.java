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
        double firstLine = sqrt(pow((points[0].x - points[1].x), 2) + pow((points[0].y - points[1].y), 2) + pow((points[0].z - points[1].z), 2));
        double secondLine = sqrt(pow((points[2].x - points[1].x), 2) + pow((points[2].y - points[1].y), 2) + pow((points[2].z - points[1].z), 2));
        double thirdLine = sqrt(pow((points[0].x - points[2].x), 2) + pow((points[0].y - points[2].y), 2) + pow((points[0].z - points[2].z), 2));

        if (points[0].x == points[1].x && points[0].y == points[1].y && points[0].z == points[1].z
                || points[0].x == points[2].x && points[0].y == points[2].y && points[0].z == points[2].z
                || points[2].x == points[1].x && points[2].y == points[1].y && points[2].z == points[1].z) {
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
        double firstLine = sqrt(pow((points[0].x - points[1].x), 2) + pow((points[0].y - points[1].y), 2) + pow((points[0].z - points[1].z), 2));
        double secondLine = sqrt(pow((points[2].x - points[1].x), 2) + pow((points[2].y - points[1].y), 2) + pow((points[2].z - points[1].z), 2));
        double thirdLine = sqrt(pow((points[0].x - points[2].x), 2) + pow((points[0].y - points[2].y), 2) + pow((points[0].z - points[2].z), 2));
        double halfPerimeter = (firstLine + secondLine + thirdLine) / 2;
        double area = sqrt(halfPerimeter * (halfPerimeter - firstLine) * (halfPerimeter - secondLine) * (halfPerimeter - thirdLine));
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }

    @Override
    public void perimeter() {
        double firstLine = sqrt(pow((points[0].x - points[1].x), 2) + pow((points[0].y - points[1].y), 2) + pow((points[0].z - points[1].z), 2));
        double secondLine = sqrt(pow((points[2].x - points[1].x), 2) + pow((points[2].y - points[1].y), 2) + pow((points[2].z - points[1].z), 2));
        double thirdLine = sqrt(pow((points[0].x - points[2].x), 2) + pow((points[0].y - points[2].y), 2) + pow((points[0].z - points[2].z), 2));
        double perimeter = firstLine + secondLine + thirdLine;
        String result = String.format("%.2f", perimeter).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}
