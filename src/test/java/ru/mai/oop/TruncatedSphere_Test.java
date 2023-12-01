package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.TruncatedSphere;
import static ru.mai.oop.elements.Constants.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruncatedSphere_Test {
    private Point[] validCoordinates = {
            new Point(COORDINATE_ZERO, COORDINATE_ZERO, COORDINATE_ZERO),
            new Point(COORDINATE_FIVE, COORDINATE_ZERO, COORDINATE_ZERO),
            new Point(COORDINATE_FOUR, COORDINATE_ZERO, COORDINATE_THREE)
    };
    TruncatedSphere validTruncatedSphere = new TruncatedSphere(validCoordinates);

    private Point[] invalidCoordinates = {
            new Point(COORDINATE_ZERO, COORDINATE_ZERO, COORDINATE_ZERO),
            new Point(COORDINATE_ZERO, COORDINATE_ZERO, COORDINATE_TWO),
            new Point(COORDINATE_ZERO, COORDINATE_ZERO, COORDINATE_ONE)
    };
    TruncatedSphere invalidTruncatedSphere = new TruncatedSphere(invalidCoordinates);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("check vaidity of truncatedSphere")
    public void checkVaidityOfTruncatedSphere() {
        boolean valid = validTruncatedSphere.rightFigure();
        then(valid).isEqualTo(true);

        valid = invalidTruncatedSphere.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("check area of truncatedSphere")
    public void checkAreaOfTruncatedSphere() {
        validTruncatedSphere.area();
        assertEquals("The figure area 113.10", output.toString().trim());
    }

    @Test
    @DisplayName("check perimeter of truncatedSphere")
    public void checkPerimeterOfTruncatedSphere() {
        validTruncatedSphere.perimeter();
        assertEquals("The figure has no perimeter", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
