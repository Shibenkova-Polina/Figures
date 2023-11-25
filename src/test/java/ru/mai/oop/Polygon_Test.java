package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Polygon;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Polygon_Test {
    public Point[] fCoordinate = {
            new Point(-1, 0),
            new Point(3, 0),
            new Point(1, 4, 0)
    };
    Polygon fPolygon = new Polygon(fCoordinate);

    public Point[] sCoordinate = {
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3),
    };
    Polygon sPolygon = new Polygon(sCoordinate);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("right polygon")
    public void rightParallelogram() {
        boolean valid = fPolygon.rightFigure();
        then(valid).isEqualTo(true);

        valid = sPolygon.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("polygon area")
    public void polygonArea() {
        fPolygon.area();
        Assertions Assert = null;
        Assert.assertEquals("The figure area 8.00", output.toString().trim());
    }

    @Test
    @DisplayName("polygon perimeter")
    public void polygonPerimeter() {
        fPolygon.perimeter();
        Assertions Assert = null;
        Assert.assertEquals("The figure perimeter 12.94", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}