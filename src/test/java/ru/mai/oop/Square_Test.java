package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Square;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Square_Test {
    private static final int COORDINATE_ZERO = 0;
    private static final int COORDINATE_ONE = 1;
    private static final int COORDINATE_TWO = 2;
    private static final int COORDINATE_THREE = 3;

    private Point[] validCoordinates = {
            new Point(COORDINATE_ONE, COORDINATE_ONE),
            new Point(COORDINATE_THREE, COORDINATE_ONE),
            new Point(COORDINATE_THREE, COORDINATE_THREE, COORDINATE_ZERO),
            new Point(COORDINATE_ONE, COORDINATE_THREE)
    };
    Square validSquare = new Square(validCoordinates);

    private Point[] invalidCoordinates = {
            new Point(COORDINATE_ONE, COORDINATE_ONE),
            new Point(COORDINATE_THREE, COORDINATE_ONE),
            new Point(COORDINATE_THREE, COORDINATE_TWO),
            new Point(COORDINATE_ONE, COORDINATE_TWO)
    };
    Square invalidSquare = new Square(invalidCoordinates);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("check vaidity of square")
    public void checkVaidityOfSquare() {
        boolean valid = validSquare.rightFigure();
        then(valid).isEqualTo(true);

        valid = invalidSquare.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("check area of square")
    public void checkAreaOfSquare() {
        validSquare.area();
        assertEquals("The figure area 4.00", output.toString().trim());
    }

    @Test
    @DisplayName("check perimeter of square")
    public void checkPerimeterOfSquare() {
        validSquare.perimeter();
        assertEquals("The figure perimeter 8.00", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
