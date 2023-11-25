package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Parallelogram;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Parallelogram_Test {
    private Point[] validCoordinates = {
            new Point(1, 1),
            new Point(5, 1),
            new Point(6, 3, 0),
            new Point(2, 3)
    };
    Parallelogram validParallelogram = new Parallelogram(validCoordinates);

    private Point[] invalidCoordinates = {
            new Point(5, 1),
            new Point(7, 3),
            new Point(2, 3),
            new Point(1, 1)
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
