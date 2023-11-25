package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Rectangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Rectangle_Test {
    public Point[] fCoordinate = {
            new Point(1, 1),
            new Point(3, 1),
            new Point(3, 2, 0),
            new Point(1, 2)
    };
    Rectangle fRectangle = new Rectangle(fCoordinate);

    public Point[] sCoordinate = {
            new Point(1, 1),
            new Point(2, 1),
            new Point(2, 2),
            new Point(1, 3)
    };
    Rectangle sRectangle = new Rectangle(sCoordinate);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("right rectangle")
    public void rightRectangle() {
        boolean valid = fRectangle.rightFigure();
        then(valid).isEqualTo(true);

        valid = sRectangle.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("rectangle area")
    public void rectangleArea() {
        fRectangle.area();
        Assertions Assert = null;
        Assert.assertEquals("The figure area 2.00", output.toString().trim());
    }

    @Test
    @DisplayName("rectangle perimeter")
    public void rectanglePerimeter() {
        fRectangle.perimeter();
        Assertions Assert = null;
        Assert.assertEquals("The figure perimeter 6.00", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
