package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Cylinder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Cylinder_Test {
    private Point[] validCoordinates = {
            new Point(0, 0, 0),
            new Point(0, 0, 4),
            new Point(2, 0, 0)
    };
    Cylinder validCylinder = new Cylinder(validCoordinates);

    private Point[] invalidCoordinates = {
            new Point(0, 0, 0),
            new Point(0, 0, 4),
            new Point(1, 1, 3)
    };
    Cylinder invalidCylinder = new Cylinder(invalidCoordinates);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("check vaidity of cylinder")
    public void checkVaidityOfCylinder() {
        boolean valid = validCylinder.rightFigure();
        then(valid).isEqualTo(true);

        valid = invalidCylinder.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("check area of cylinder")
    public void checkAreaOfCylinder() {
        validCylinder.area();
        assertEquals("The figure area 75.40", output.toString().trim());
    }

    @Test
    @DisplayName("check perimeter of cylinder")
    public void checkPerimeterOfCylinder() {
        validCylinder.perimeter();
        assertEquals("The figure has no perimeter", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
