package ru.mai.oop;

import org.junit.jupiter.api.*;
import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.Circle;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Circle_Test {
        private Point[] coordinates = {
                new Point(1, 1),
                new Point(2, 1)
        };
        Circle circle = new Circle(coordinates);

        private ByteArrayOutputStream output = new ByteArrayOutputStream();
        private final PrintStream standardOut = System.out;

        @Test
        @DisplayName("check vaidity of circle")
        public void checkVaidityOfCircle() {
            boolean valid = circle.rightFigure();
            then(valid).isEqualTo(true);
        }

        @BeforeEach
        public void setUp() {
            System.setOut(new PrintStream(output));
        }

        @Test
        @DisplayName("check area of circle")
        public void checkAreaOfCircle() {
            circle.area();
            assertEquals("The figure area 3.14", output.toString().trim());
        }

        @Test
        @DisplayName("check perimeter of circle")
        public void checkPerimeterOfCircle() {
            circle.perimeter();
            assertEquals("The figure perimeter 6.28", output.toString().trim());
        }

        @AfterEach
        public void tearDown() {
            System.setOut(standardOut);
        }
}
