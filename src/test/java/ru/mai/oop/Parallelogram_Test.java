package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Parallelogram;
import static ru.mai.oop.elements.Constants.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Parallelogram_Test {
    private Point[] validCoordinates = {
            new Point(COORDINATE_ONE, COORDINATE_ONE),
            new Point(COORDINATE_FIVE, COORDINATE_ONE),
            new Point(COORDINATE_SIX, COORDINATE_THREE, COORDINATE_ZERO),
            new Point(COORDINATE_TWO, COORDINATE_THREE)
    };
    Parallelogram validParallelogram = new Parallelogram(validCoordinates);

    private Point[] invalidCoordinates = {
            new Point(COORDINATE_FIVE, COORDINATE_ONE),
            new Point(COORDINATE_SEVEN, COORDINATE_THREE),
            new Point(COORDINATE_TWO, COORDINATE_THREE),
            new Point(COORDINATE_ONE, COORDINATE_ONE)
    };
    Parallelogram invalidParallelogram = new Parallelogram(invalidCoordinates);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("check vaidity of parallelogram")
    public void checkVaidityOfParallelogram() {
        boolean valid = validParallelogram.rightFigure();
        then(valid).isEqualTo(true);

        valid = invalidParallelogram.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("check area of parallelogram")
    public void checkAreaOfParallelogram() {
        validParallelogram.area();
        assertEquals("The figure area 8.00", output.toString().trim());
    }

    @Test
    @DisplayName("check perimeter of parallelogram")
    public void checkPerimeterOfParallelogram() {
        validParallelogram.perimeter();
        assertEquals("The figure perimeter 12.47", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
