package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Cone;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Cone_Test {
    private Point[] validCoordinates = {
            new Point(1, 1, 0),
            new Point(1, 0, 0),
            new Point(1, 1, 3)
    };
    Cone validCone = new Cone(validCoordinates);

    private Point[] invalidCoordinates = {
            new Point(1, 1, 0),
            new Point(1, 0, 0),
            new Point(1, 0, 3)
    };
    Cone invalidCone = new Cone(invalidCoordinates);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("check vaidity of cone")
    public void checkVaidityOfCone() {
        boolean valid = validCone.rightFigure();
        then(valid).isEqualTo(true);

        valid = invalidCone.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("check area of cone")
    public void checkAreaOfCone() {
        validCone.area();
        assertEquals("The figure area 13.08", output.toString().trim());
    }

    @Test
    @DisplayName("check perimeter of cone")
    public void checkPerimeterOfCone() {
        validCone.perimeter();
        assertEquals("The figure has no perimeter", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
