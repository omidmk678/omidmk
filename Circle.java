/**
 * This class holds information of circle
 */
public class Circle extends Shape{

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

    @Override
    public double calculatePerimeter() {
        return 2*Math.PI*radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
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
