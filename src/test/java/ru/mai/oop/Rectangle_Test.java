package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Rectangle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Rectangle_Test {
    private Point[] validCoordinates = {
            new Point(1, 1),
            new Point(3, 1),
            new Point(3, 2, 0),
            new Point(1, 2)
    };
    Rectangle validRectangle = new Rectangle(validCoordinates);

    private Point[] invalidCoordinates = {
            new Point(1, 1),
            new Point(2, 1),
            new Point(2, 2),
            new Point(1, 3)
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
