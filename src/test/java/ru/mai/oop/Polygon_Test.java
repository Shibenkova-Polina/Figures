package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Polygon;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Polygon_Test {
    private Point[] validCoordinates = {
            new Point(-1, 0),
            new Point(3, 0),
            new Point(1, 4, 0)
    };
    Polygon validPolygon = new Polygon(validCoordinates);

    private Point[] invalidCoordinates = {
            new Point(1, 1),
            new Point(2, 2),
            new Point(3, 3)
    };
    Polygon invalidPolygon = new Polygon(invalidCoordinates);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("check vaidity of polygon")
    public void checkVaidityOfParallelogram() {
        boolean valid = validPolygon.rightFigure();
        then(valid).isEqualTo(true);

        valid = invalidPolygon.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("check area of polygon")
    public void checkAreaOfPolygon() {
        validPolygon.area();
        assertEquals("The figure area 8.00", output.toString().trim());
    }

    @Test
    @DisplayName("check perimeter of polygon")
    public void checkPerimeterOfPolygon() {
        validPolygon.perimeter();
        assertEquals("The figure perimeter 12.94", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
