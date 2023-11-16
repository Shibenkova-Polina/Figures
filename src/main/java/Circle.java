import static java.lang.Math.sqrt;
import static java.lang.Math.pow;
import static java.lang.Math.PI;

public class Circle extends Figure {

    private final Point[] points;

    public Circle() {
        this.points = new Point[0];
    }

    public Circle(Point[] coordinate) {
        this.points = coordinate;
    }

    @Override
    public boolean rightFigure() {
        System.out.println("The figure is valid");
        return true;
    }

    @Override
    public void area() {
        double radius = sqrt(pow((points[0].x - points[1].x), 2) + pow((points[0].y - points[1].y), 2) + pow((points[0].z - points[1].z), 2));
        double area = PI * pow(radius, 2);
        String result = String.format("%.2f", area).replace(',', '.');
        System.out.println("The figure area " + result);
    }

    @Override
    public void perimeter() {
        double radius = sqrt(pow((points[0].x - points[1].x), 2) + pow((points[0].y - points[1].y), 2) + pow((points[0].z - points[1].z), 2));
        double perimeter = 2 * PI * radius;
        String result = String.format("%.2f", perimeter).replace(',', '.');
        System.out.println("The figure perimeter " + result);
    }
}
