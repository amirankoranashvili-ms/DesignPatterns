import java.util.List;

public class Main {
    public static void main(String[] args) {

    }

    static double total(List<Shape> shapes) {
        return shapes.stream()
                .mapToDouble(Shape::area)
                .sum();
    }

    static abstract class Shape {
        abstract double area();
    }
}
