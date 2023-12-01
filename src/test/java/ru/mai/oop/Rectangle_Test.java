package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Rectangle;
import static ru.mai.oop.elements.Constants.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Rectangle_Test {
    private Point[] validCoordinates = {
            new Point(COORDINATE_ONE, COORDINATE_ONE),
            new Point(COORDINATE_THREE, COORDINATE_ONE),
            new Point(COORDINATE_THREE, COORDINATE_TWO, COORDINATE_ZERO),
            new Point(COORDINATE_ONE, COORDINATE_TWO)
    };
    Rectangle validRectangle = new Rectangle(validCoordinates);

    private Point[] invalidCoordinates = {
            new Point(COORDINATE_ONE, COORDINATE_ONE),
            new Point(COORDINATE_TWO, COORDINATE_ONE),
            new Point(COORDINATE_TWO, COORDINATE_TWO),
            new Point(COORDINATE_ONE, COORDINATE_THREE)
    };
    Rectangle invalidRectangle = new Rectangle(invalidCoordinates);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("check vaidity of rectangle")
    public void checkVaidityOfRectangle() {
        boolean valid = validRectangle.rightFigure();
        then(valid).isEqualTo(true);

        valid = invalidRectangle.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("check area of rectangle")
    public void checkAreaOfRectangle() {
        validRectangle.area();
        assertEquals("The figure area 2.00", output.toString().trim());
    }

    @Test
    @DisplayName("check perimeter of rectangle")
    public void checkPerimeterOfRectangle() {
        validRectangle.perimeter();
        assertEquals("The figure perimeter 6.00", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
