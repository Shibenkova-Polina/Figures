package ru.mai.oop;

import ru.mai.oop.elements.Point;
import ru.mai.oop.figures.*;
import static ru.mai.oop.elements.Constants.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean valid = false;

        while (!valid) {
            Figure figure = chooseFigure(sc);

            if (figure == null) {
                valid = true;
            }

            if (!valid) {
                ArrayList<Point> coordinates;
                coordinates = inputCoordinate(sc, figure);
                Point[] points = new Point[coordinates.size()];
                coordinates.toArray(points);

                figure = createFigure(figure, points);
                valid = validate(figure, points);

                if (valid) {
                    if (figure != null) {
                        figure.area();
                    }
                    if (figure != null) {
                        figure.perimeter();
                    }
                }

                valid = false;
            }
        }
    }

    public static boolean validate(Figure figure, Point[] points) {
        boolean checkPoints = false;
        if (figure != null) {
            checkPoints = true;

            if (figure instanceof Circle && points.length != TWO_COORDINATES) {
                checkPoints = false;
            } else if (figure instanceof Cone && points.length != THREE_COORDINATES) {
                checkPoints = false;
            } else if (figure instanceof Cylinder && points.length != THREE_COORDINATES) {
                checkPoints = false;
            } else if (figure instanceof Parallelogram && points.length != FOUR_COORDINATES) {
                checkPoints = false;
            } else if (figure instanceof Rectangle && points.length != FOUR_COORDINATES) {
                checkPoints = false;
            } else if (figure instanceof Square && points.length != FOUR_COORDINATES) {
                checkPoints = false;
            } else if (figure instanceof Sphere && points.length != TWO_COORDINATES) {
                checkPoints = false;
            } else if (figure instanceof Polygon && points.length < THREE_COORDINATES) {
                checkPoints = false;
            } else if (figure instanceof Triangle && points.length != THREE_COORDINATES) {
                checkPoints = false;
            } else if (figure instanceof TruncatedSphere && points.length != THREE_COORDINATES) {
                checkPoints = false;
            }
        }

        if (checkPoints) {
            return figure.rightFigure();
        } else {
            System.out.println("it is impossible to build a figure based on these coordinates");
        }

        return false;
    }

    public static Figure createFigure(Figure figure, Point[] points) {
       if (figure instanceof Circle) {
            return new Circle(points);
       } else if (figure instanceof Cone) {
            return new Cone(points);
       } else if (figure instanceof Cylinder) {
            return new Cylinder(points);
       } else if (figure instanceof Polygon) {
            return new Polygon(points);
       } else if (figure instanceof Parallelogram) {
            return new Parallelogram(points);
       } else if (figure instanceof Rectangle) {
            return new Rectangle(points);
       } else if (figure instanceof Square) {
            return new Square(points);
       } else if (figure instanceof Sphere) {
            return new Sphere(points);
       } else if (figure instanceof Triangle) {
            return new Triangle(points);
       } else if (figure instanceof TruncatedSphere) {
            return new TruncatedSphere(points);
       }  else if (figure != null) {
            return new Figure();
       }

       return null;
    }

    public enum Command {FIGURE, CIRCLE, SQUARE, RECTANGLE, PARALLELOGRAM, TRIANGLE, POLYGON, SPHERE, TRUNCATED_SPHERE, CYLINDER, CONE, END}

    public static Figure chooseFigure(Scanner sc) {
        do {
            String figureName = sc.nextLine();
            Command command = null;
            boolean check = true;

            try {
                command = Command.valueOf(figureName);
            } catch (IllegalArgumentException e) {
                System.out.println("Incorrect input. The program expects: FIGURE/CIRCLE/SQUARE/RECTANGLE/PARALLELOGRAM/TRIANGLE/"
                        + "POLYGON/SPHERE/TRUNCATED_SPHERE/CYLINDER/CONE/END");
                check = false;
            }

            if (check) {
                return switch (command) {
                    case FIGURE -> new Figure();
                    case CIRCLE -> new Circle();
                    case SQUARE -> new Square();
                    case RECTANGLE -> new Rectangle();
                    case PARALLELOGRAM -> new Parallelogram();
                    case TRIANGLE -> new Triangle();
                    case POLYGON -> new Polygon();
                    case SPHERE -> new Sphere();
                    case TRUNCATED_SPHERE -> new TruncatedSphere();
                    case CYLINDER -> new Cylinder();
                    case CONE -> new Cone();
                    case END -> null;
                };
            }
        } while (true);
    }

    public static ArrayList<Point> inputCoordinate(Scanner sc, Figure figure) {
        ArrayList<Point> coordinates = new ArrayList<>();

        while (true) {
            String line = sc.nextLine();

            Pattern fPattern = Pattern.compile("(-?\\d+\\s-?\\d+)");
            Matcher fMatcher = fPattern.matcher(line);

            Pattern sPattern = Pattern.compile("(-?\\d+\\s-?\\d+\\s-?\\d+)");
            Matcher sMatcher = sPattern.matcher(line);

            if (fMatcher.matches()) {
                if (figure instanceof Cone || figure instanceof Cylinder || figure instanceof Sphere || figure instanceof TruncatedSphere) {
                    System.out.println("Three coordinates are needed for the specified shape");
                } else {
                    String[] nums = line.split(" ");
                    int[] points = new int[nums.length];

                    for (int i = 0; i < nums.length; i++) {
                        points[i] = Integer.parseInt(nums[i]);
                    }
                    Point point = new Point(points[INDEX_ZERO], points[INDEX_ONE]);
                    coordinates.add(point);
                }
            } else if (sMatcher.matches()) {
                String[] nums = line.split(" ");
                int[] points = new int[nums.length];

                for (int i = 0; i < nums.length; i++) {
                    points[i] = Integer.parseInt(nums[i]);
                }
                Point point = new Point(points[INDEX_ZERO], points[INDEX_ONE], points[INDEX_TWO]);
                coordinates.add(point);
            } else if (line.equals("STOP_INPUT")) {
                return coordinates;
            } else {
                System.out.println("Please, retype");
            }
        }
    }
}