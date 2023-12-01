package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Sphere;
import static ru.mai.oop.elements.Constants.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sphere_Test {
    private Point[] coordinates = {
            new Point(COORDINATE_ONE, COORDINATE_ONE, COORDINATE_ONE),
            new Point(COORDINATE_ONE, COORDINATE_TWO, COORDINATE_ONE)
    };
    Sphere sphere = new Sphere(coordinates);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("check vaidity of sphere")
    public void checkVaidityOfSphere() {
        boolean valid = sphere.rightFigure();
        then(valid).isEqualTo(true);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("check area of sphere")
    public void checkAreaOfSphere() {
        sphere.area();
        assertEquals("The figure area 12.57", output.toString().trim());
    }

    @Test
    @DisplayName("check perimeter of sphere")
    public void checkPerimeterOfSphere() {
        sphere.perimeter();
        assertEquals("The figure has no perimeter", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
