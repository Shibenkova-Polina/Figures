package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Parallelogram;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Parallelogram_Test {
    public Point[] fCoordinate = {
            new Point(1, 1),
            new Point(5, 1),
            new Point(6, 3, 0),
            new Point(2, 3)
    };
    Parallelogram fParallelogram = new Parallelogram(fCoordinate);

    public Point[] sCoordinate = {
            new Point(5, 1),
            new Point(7, 3),
            new Point(2, 3),
            new Point(1, 1)
    };
    Parallelogram sParallelogram = new Parallelogram(sCoordinate);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("right parallelogram")
    public void rightParallelogram() {
        boolean valid = fParallelogram.rightFigure();
        then(valid).isEqualTo(true);

        valid = sParallelogram.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("parallelogram area")
    public void parallelogramArea() {
        fParallelogram.area();
        Assertions Assert = null;
        Assert.assertEquals("The figure area 8.00", output.toString().trim());
    }

    @Test
    @DisplayName("parallelogram perimeter")
    public void parallelogramPerimeter() {
        fParallelogram.perimeter();
        Assertions Assert = null;
        Assert.assertEquals("The figure perimeter 12.47", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
