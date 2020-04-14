import java.util.ArrayList;
import java.util.Objects;

/**
 * This class holds information of rectangles.
 */
public class Rectangle {

    private ArrayList<Integer> sides;

    /**
     * Constructor for Rectangle
     * @param side1 first side of rectangle
     * @param side2 second side of rectangle
     * @param side3 third side of rectangle
     * @param side4 fourth side of rectangle
     */
    public Rectangle(int side1, int side2, int side3, int side4) {
        sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        sides.add(side4);
    }

    /**
     * getter for rectangle's sides
     * @return sides of rectangle
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * check if is shape square
     * @return true if shape is a square false otherwise
     */
    public boolean isSquare() {
        return sides.get(0).equals(sides.get(1)) && sides.get(0).equals(sides.get(2)) && sides.get(0).equals(sides.get(3));
    }

    /**
     * This method will calculate rectangle's perimeter.
     * @return perimeter of rectangle.
     */
    public double calculatePerimeter() {
        return sides.get(0) + sides.get(1) + sides.get(2) + sides.get(3);
    }
    /**
     * This method will calculate rectangle's area.
     * @return Area of rectangle.
     */
    public double calculateArea() {
        return sides.get(0) * sides.get(1);
    }

    /**
     * print the area and perimeter of triangle.
     */
    public void draw() {
        System.out.println("Shape is Rectangle.");
        System.out.printf("Perimeter = %.2f | Area = %.2f\n",calculatePerimeter(),calculateArea());
    }

    @Override
    public String toString() {
        String str = "Rectangle | ";
        for (int i = 0; i < 4; i++){
            str = str.concat("Side " + (i+1) + " : " + sides.get(i));
            if(i != 3) str = str.concat(" , ");
        }
        return str + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(sides, rectangle.sides);
    }
}
