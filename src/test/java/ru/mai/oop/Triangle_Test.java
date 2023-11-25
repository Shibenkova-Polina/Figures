package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Triangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Triangle_Test {
    private Point[] validCoordinates = {
            new Point(-1, 0),
            new Point(3, 0),
            new Point(1, 4, 0)
    };
    Triangle validTriangle = new Triangle(validCoordinates);

    private Point[] invalidCoordinates = {
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3)
    };
    Triangle invalidTriangle = new Triangle(invalidCoordinates);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("check vaidity of triangle")
    public void checkVaidityOfTriangle() {
        boolean valid = validTriangle.rightFigure();
        then(valid).isEqualTo(true);

        valid = invalidTriangle.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("check area of triangle")
    public void checkAreaOfTriangle() {
        validTriangle.area();
        assertEquals("The figure area 8.00", output.toString().trim());
    }

    @Test
    @DisplayName("check perimeter of triangle")
    public void checkPerimeterOfTriangle() {
        validTriangle.perimeter();
        assertEquals("The figure perimeter 12.94", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
