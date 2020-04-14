import java.util.ArrayList;

/**
 * This class holds shapes.
 */
public class Paint {

    private ArrayList<Circle> circles;
    private ArrayList<Triangle> triangles;
    private ArrayList<Rectangle> rectangles;

    /**
     * Constructor for Paint class
     */
    public Paint(){
        circles = new ArrayList<>();
        triangles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    /**
     * This method will add a specific triangle.
     * @param triangleToAdd triangle to add.
     */
    public void addTriangle(Triangle triangleToAdd) {
        triangles.add(triangleToAdd);
    }

    /**
     * This method will add a specific circle.
     * @param circleToAdd circle to add.
     */
    public void addCircle(Circle circleToAdd) {
        circles.add(circleToAdd);
    }

    /**
     * This method will add a specific rectangle.
     * @param rectangleToAdd rectangle to add.
     */
    public void addRectangle(Rectangle rectangleToAdd) {
        rectangles.add(rectangleToAdd);
    }

    /**
     * This method will call shapes draw function.
     */
    public void drawAll() {
        System.out.println("Circles :\n");
        for (Circle circle : circles)
            circle.draw();
        System.out.println("\nTriangles :\n");
        for (Triangle triangle : triangles)
            triangle.draw();
        System.out.println("\nRectangles :");
        for (Rectangle rectangle : rectangles)
            rectangle.draw();
        System.out.println();
    }

    /**
     * This method will print shapes information.
     */
    public void printAll() {
        System.out.println("Circles :\n");
        for (Circle circle : circles)
            System.out.print(circle);
        System.out.print("\nTriangles :\n");
        for (Triangle triangle : triangles)
            System.out.print(triangle);
        System.out.println("\nRectangles :");
        for (Rectangle rectangle : rectangles)
            System.out.print(rectangle);
        System.out.println();
    }
}