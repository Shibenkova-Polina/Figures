package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Cylinder;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Cylinder_Test {
    public Point[] fCoordinate = {
            new Point(0, 0, 0),
            new Point(0, 0, 4),
            new Point(2, 0, 0)
    };
    Cylinder fCylinder = new Cylinder(fCoordinate);

    public Point[] sCoordinate = {
            new Point(0, 0, 0),
            new Point(0, 0, 4),
            new Point(1, 1, 3)
    };
    Cylinder sCylinder = new Cylinder(sCoordinate);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("right cylinder")
    public void rightCylinder() {
        boolean valid = fCylinder.rightFigure();
        then(valid).isEqualTo(true);

        valid = sCylinder.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("cylinder area")
    public void cylinderArea() {
        fCylinder.area();
        Assertions Assert = null;
        Assert.assertEquals("The figure area 75.40", output.toString().trim());
    }

    @Test
    @DisplayName("cylinder perimeter")
    public void cylinderPerimeter() {
        fCylinder.perimeter();
        Assertions Assert = null;
        Assert.assertEquals("The figure has no perimeter", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
