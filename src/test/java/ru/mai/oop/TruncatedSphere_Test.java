package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.TruncatedSphere;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruncatedSphere_Test {
    public Point[] fCoordinate = {
            new Point(0, 0, 0),
            new Point(5, 0, 0),
            new Point(4, 0, 3),
    };
    TruncatedSphere fTruncatedSphere = new TruncatedSphere(fCoordinate);

    public Point[] sCoordinate = {
            new Point(0, 0, 0),
            new Point(0, 0, 2),
            new Point(0, 0, 1),
    };
    TruncatedSphere sTruncatedSphere = new TruncatedSphere(sCoordinate);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("right truncatedSphere")
    public void rightTruncatedSphere() {
        boolean valid = fTruncatedSphere.rightFigure();
        then(valid).isEqualTo(true);

        valid = sTruncatedSphere.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("parallelogram area")
    public void truncatedSphereArea() {
        fTruncatedSphere.area();
        Assertions Assert = null;
        Assert.assertEquals("The figure area 113.10", output.toString().trim());
    }

    @Test
    @DisplayName("parallelogram perimeter")
    public void parallelogramPerimeter() {
        fTruncatedSphere.perimeter();
        Assertions Assert = null;
        Assert.assertEquals("The figure has no perimeter", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
