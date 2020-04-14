public class Triangle extends Polygon{
    /**
     * Constructor for Triangle
     * @param sides sides of triangle
     */
    public Triangle(int... sides){
        super(sides);
    }
    /**
     * check if is shape Equilateral
     * @return true if shape is a Equilateral false otherwise
     */
    public boolean isEquilateral(){
        return sides.get(0).equals(sides.get(1)) && sides.get(1).equals(sides.get(2));
    }

    @Override
    public double calculateArea() {
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p- sides.get(0)) * (p - sides.get(1)) * (p - sides.get(2)));
    }

    @Override
    public double calculatePerimeter() {
        double sum = 0;
        for (int side : sides){
            sum += side;
        }
        return sum;
    }

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
