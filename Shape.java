/**
 * This class holds methods and information of shapes.
 */
public abstract class Shape extends Paint {
    /**
     * This method will calculate shape's perimeter.
     * @return perimeter of shape.
     */
    public abstract double calculatePerimeter();
    /**
     * This method will calculate shape's area.
     * @return Area of shape.
     */
    public abstract double calculateArea();
    /**
     * print the area and perimeter of shape
     */
    public abstract void draw();

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public abstract String toString();
}
