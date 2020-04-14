import java.util.Objects;
/**
 * This class holds information of rectangles.
 */
public class Rectangle extends Polygon{

    /**
     * Constructor for Rectangle
     * @param sides sides of rectangle
     */
    public Rectangle(int... sides){
        super(sides);
    }

    /**
     * check if is shape square
     * @return true if shape is a square false otherwise
     */
    public boolean isSquare(){
        return sides.get(0).equals(sides.get(1)) && sides.get(0).equals(sides.get(2)) && sides.get(0).equals(sides.get(3));
    }

    @Override
    public double calculatePerimeter() {
        double sum = 0;
        for (int side : sides){
            sum += side;
        }
        return sum;
    }
    @Override
    public double calculateArea() {
        return sides.get(0) * sides.get(1);
    }
    @Override
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
