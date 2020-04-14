import java.util.ArrayList;
/**
 * This class holds shapes.
 */
public class Paint {

    private ArrayList<Shape> shapes;

    /**
     * Constructor for Paint class
     */
    public Paint(){
        shapes = new ArrayList<>();
    }

    /**
     * This method will add a specific shape.
     * @param shapeToAdd shape to add.
     */
    public void addShape(Shape shapeToAdd){
        shapes.add(shapeToAdd);
    }

    /**
     * This method will call shapes draw function.
     */
    public void drawAll(){
        for (Shape shape : shapes)
            shape.draw();
    }

    /**
     * This method will print shapes information.
     */
    public void printAll(){
        for (Shape shape : shapes)
            System.out.println(shape);
    }
}
