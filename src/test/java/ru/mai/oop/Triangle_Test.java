package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Triangle_Test {
    public Point[] fCoordinate = {
            new Point(-1, 0),
            new Point(3, 0),
            new Point(1, 4, 0)
    };
    Triangle fTriangle = new Triangle(fCoordinate);

    public Point[] sCoordinate = {
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3)
    };
    Triangle sTriangle = new Triangle(sCoordinate);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("right triangle")
    public void rightTriangle() {
        boolean valid = fTriangle.rightFigure();
        then(valid).isEqualTo(true);

        valid = sTriangle.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("triangle area")
    public void triangleArea() {
        fTriangle.area();
        Assertions Assert = null;
        Assert.assertEquals("The figure area 8.00", output.toString().trim());
    }

    @Test
    @DisplayName("triangle perimeter")
    public void trianglePerimeter() {
        fTriangle.perimeter();
        Assertions Assert = null;
        Assert.assertEquals("The figure perimeter 12.94", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
