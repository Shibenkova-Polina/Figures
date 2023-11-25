package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Square;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Square_Test {
    public Point[] fCoordinate = {
            new Point(1, 1),
            new Point(3, 1),
            new Point(3, 3, 0),
            new Point(1, 3)
    };
    Square fSquare = new Square(fCoordinate);

    public Point[] sCoordinate = {
            new Point(1, 1),
            new Point(3, 1),
            new Point(3, 2),
            new Point(1, 2)
    };
    Square sSquare = new Square(sCoordinate);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("right square")
    public void rightSquare() {
        boolean valid = fSquare.rightFigure();
        then(valid).isEqualTo(true);

        valid = sSquare.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("square area")
    public void squareArea() {
        fSquare.area();
        Assertions Assert = null;
        Assert.assertEquals("The figure area 4.00", output.toString().trim());
    }

    @Test
    @DisplayName("square perimeter")
    public void squarePerimeter() {
        fSquare.perimeter();
        Assertions Assert = null;
        Assert.assertEquals("The figure perimeter 8.00", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
