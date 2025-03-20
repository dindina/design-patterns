package soliddesign;
interface Shapee {
    int getArea();
}

class Rectangleee implements Shapee {
    protected int width;
    protected int height;

    public Rectangleee(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

class Squareee implements Shapee {
    private int side;

    public Squareee(int side) {
        this.side = side;
    }

    public int getArea() {
        return side * side;
    }
}

public class LiskovPrincipleFollowed {
    public static void main(String[] args) {
        Shapee rectangle = new Rectangleee(5, 10);
        System.out.println("Rectangle Area: " + rectangle.getArea()); // Output: 50

        Shapee square = new Squareee(5);
        System.out.println("Square Area: " + square.getArea()); // Output: 25
    }

    public static void processShape(Shapee shape){
        System.out.println("Shape area: " + shape.getArea());
    }
}

