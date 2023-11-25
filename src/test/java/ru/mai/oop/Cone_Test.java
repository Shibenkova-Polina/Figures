package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Cone;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Cone_Test {
    public Point[] fCoordinate = {
            new Point(1, 1, 0),
            new Point(1, 0, 0),
            new Point(1, 1, 3)
    };
    Cone fCone = new Cone(fCoordinate);

    public Point[] sCoordinate = {
            new Point(1, 1, 0),
            new Point(1, 0, 0),
            new Point(1, 0, 3)
    };
    Cone sCone = new Cone(sCoordinate);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("right cone")
    public void rightCone() {
        boolean valid = fCone.rightFigure();
        then(valid).isEqualTo(true);

        valid = sCone.rightFigure();
        then(valid).isEqualTo(false);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("cone area")
    public void coneArea() {
        fCone.area();
        Assertions Assert = null;
        Assert.assertEquals("The figure area 13.08", output.toString().trim());
    }

    @Test
    @DisplayName("cone perimeter")
    public void conePerimeter() {
        fCone.perimeter();
        Assertions Assert = null;
        Assert.assertEquals("The figure has no perimeter", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
