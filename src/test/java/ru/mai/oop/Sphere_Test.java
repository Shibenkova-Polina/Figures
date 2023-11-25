package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Sphere;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Sphere_Test {
    public Point[] coordinate = {
            new Point(1, 1, 1),
            new Point(1, 2, 1)};
    Sphere sphere = new Sphere(coordinate);

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("right sphere")
    public void rightSphere() {
        boolean valid = sphere.rightFigure();
        then(valid).isEqualTo(true);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("sphere area")
    public void SphereArea() {
        sphere.area();
        Assertions Assert = null;
        Assert.assertEquals("The figure area 12.57", output.toString().trim());
    }

    @Test
    @DisplayName("sphere perimeter")
    public void spherePerimeter() {
        sphere.perimeter();
        Assertions Assert = null;
        Assert.assertEquals("The figure has no perimeter", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
