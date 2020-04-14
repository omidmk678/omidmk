import java.util.ArrayList;

public abstract class Polygon extends Shape {

    ArrayList<Integer> sides;

    /**
     * Constructor for polygon
     * @param sidesToAdd sides of shape
     */
    public Polygon(int... sidesToAdd){
        sides = new ArrayList<>();
        for (Integer side : sidesToAdd)
            sides.add(side);
    }

    /**
     * getter for rectangle's sides
     * @return sides of rectangle
     */
    public ArrayList<Integer> getSides() {
        return sides;
    }

    @Override
    public abstract double calculatePerimeter();
    @Override
    public abstract String toString();

}
