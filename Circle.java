/**
 * This class holds information of circle
 */
public class Circle {

    private int radius;

    /**
     * Constructor for Circle
     * @param radius radius of circle
     */
    public Circle(int radius){
        this.radius = radius;
    }

    /**
     * getter for radius
     * @return radius of circle
     */
    public int getRadius(){
        return radius;
    }

    /**
     * This method will calculate circle's perimeter.
     * @return perimeter of circle.
     */
    public double calculatePerimeter(){
        return 2*Math.PI*radius;
    }

    /**
     * This method will calculate circle's area.
     * @return Area of circle.
     */
    public double calculateArea(){
        return Math.PI*radius*radius;
    }

    /**
     * print the area and perimeter of circle
     */
    public void draw() {
        System.out.println("Shape is Circle.");
        System.out.printf("Perimeter = %.2f | Area = %.2f\n",calculatePerimeter(),calculateArea());
    }
    @Override
    public String toString() {
        return String.format("Circle | Radius : %d\n",radius);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return radius == circle.radius;
    }
}
