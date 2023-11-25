package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Figure;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Figure_Test {
    Figure figure = new Figure();

    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;

    @Test
    @DisplayName("check vaidity of figure")
    public void checkVaidityOfFigure() {
        boolean valid = figure.rightFigure();
        then(valid).isEqualTo(true);
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(output));
    }

    @Test
    @DisplayName("check area of figure")
    public void checkAreaOfFigure() {
        figure.area();
        assertEquals("The figure has no area", output.toString().trim());
    }

    @Test
    @DisplayName("check perimeter of figure")
    public void checkPerimeterOfFigure() {
        figure.perimeter();
        assertEquals("The figure has no perimeter", output.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
