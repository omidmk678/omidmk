import java.util.ArrayList;

/**
 * This class holds information of triangles.
 */
public class Triangle {

    private ArrayList<Integer> sides;
    /**
     * Constructor for triangle
     * @param side1 first side of rectangle
     * @param side2 second side of rectangle
     * @param side3 third side of rectangle
     */
    public Triangle(int side1, int side2, int side3) {
        sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
    }
    /**
     * getter for rectangle's triangle
     * @return sides of triangle
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    /**
     * check if is shape Equilateral
     * @return true if shape is a Equilateral false otherwise
     */
    public boolean isEquilateral() {
        return sides.get(0).equals(sides.get(1)) && sides.get(0).equals(sides.get(2));
    }

    /**
     * This method will calculate triangle's perimeter.
     * @return perimeter of triangle.
     */
    public double calculatePerimeter() {
        return sides.get(0) + sides.get(1) + sides.get(2) ;
    }

    /**
     * This method will calculate triangle's area.
     * @return Area of triangle.
     */
    public double calculateArea() {
        double p = calculatePerimeter()/2;
        return Math.sqrt(p*(p-sides.get(0))*(p-sides.get(1))*(p-sides.get(2)));
    }

    /**
     * print the area and perimeter of rectangle
     */
    public void draw() {
        System.out.println("Shape is Triangle.");
        System.out.printf("Perimeter = %.2f | Area = %.2f\n",calculatePerimeter(),calculateArea());
    }
    @Override
    public String toString() {
        String str = "Triangle | ";
        for (int i = 0; i < 3; i++){
            str = str.concat("Side " + (i+1) + " : " + sides.get(i));
            if(i != 2) str = str.concat(" , ");
        }
        return str + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return sides.equals(triangle.sides);
    }
}


